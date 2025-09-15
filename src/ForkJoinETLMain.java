import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;


class TransactionProcessor extends RecursiveTask<Double>{
    private static final int THRESHOLD = 1000; // process limit before splitting
    private final List<Transaction> transactions;

    TransactionProcessor(List<Transaction> transactions) {
        this.transactions = transactions;
    }


    @Override
    protected Double compute() {
        if(transactions.size() <= THRESHOLD){
            transactions.stream().filter(t->t.getAmount()>0).mapToDouble(t->t.getAmount()).sum();
        }else{
            // Split into two subtasks
            int mid = transactions.size()/2;
            TransactionProcessor firstHalf = new TransactionProcessor(transactions.subList(0,mid));
            TransactionProcessor secondHalf = new TransactionProcessor(transactions.subList(mid+1,transactions.size()));
            firstHalf.fork(); // run asynchronously
            double rightResult = secondHalf.compute(); // compute right now
            double leftResult = firstHalf.join(); // wait for left
            return leftResult + rightResult;

        }
        return null;
    }
}


public class ForkJoinETLMain {

    public static void main(String[] args) {
        List<Transaction> transactions = null;
        try {
            transactions = loadTransactions("transactions.csv");
            System.out.println("Size of Transactions :"+transactions.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ForkJoinPool pool = new ForkJoinPool(); // default parallelism = CPU cores
        TransactionProcessor processor = new TransactionProcessor(transactions);
        double total = pool.invoke(processor);
        System.out.println("Total transaction amount: " + total);
        pool.shutdown();

    }

    private static List<Transaction> loadTransactions(String fileName) throws IOException {
        return Files.lines(Paths.get(fileName))
                .map(line -> {
                    String[] parts = line.split(",");
                    System.out.println("Parsed Value: "+parts[0]+" "+parts[1]);
                    return new Transaction(parts[0], Double.parseDouble(parts[1]));
                })
                .collect(Collectors.toList());
    }
}

class Transaction {
    private String stock;
    private double amount;

    Transaction(String stock, double amount) {
        this.stock = stock;
        this.amount = amount;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
