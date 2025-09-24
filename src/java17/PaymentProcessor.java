package java17;

public class PaymentProcessor {

    public static String processEvent(PaymentEvent event) {
        return switch (event) {
            case CardPayment cp when cp.amount() > 10000 ->
                    "High-value card payment flagged for manual review: " + cp.cardNumber();
            case CardPayment cp ->
                    "Card payment processed: " + cp.cardNumber();
            case UpiPayment upi ->
                    "UPI payment processed: " + upi.upiId();
            case Refund refund ->
                    "Refund initiated for transaction: " + refund.transactionId();
            case UnknownEvent ue ->
                    "Unknown event logged: " + ue.details();
        };
    }

    public static void main(String[] args) {
        PaymentEvent e1 = new CardPayment("1234-5678-9012", 12000);
        PaymentEvent e2 = new UpiPayment("user@upi", 500);
        PaymentEvent e3 = new Refund("TXN12345", 300);
        PaymentEvent e4 = new UnknownEvent("Legacy message format");

        System.out.println(processEvent(e1));
        System.out.println(processEvent(e2));
        System.out.println(processEvent(e3));
        System.out.println(processEvent(e4));
    }
}

sealed interface PaymentEvent permits CardPayment, UpiPayment, Refund, UnknownEvent {}

record CardPayment(String cardNumber, double amount) implements PaymentEvent {}
record UpiPayment(String upiId, double amount) implements PaymentEvent {}
record Refund(String transactionId, double amount) implements PaymentEvent {}
record UnknownEvent(String details) implements PaymentEvent {}
