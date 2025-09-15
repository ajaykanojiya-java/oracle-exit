package multithreading;

import java.util.Random;

public class BankAccountTest {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(10000);
        Random random = new Random();

        Runnable depositTask = ()->{
            for(int i = 0; i<10;i++){
                double value = random.nextDouble(100);
                double rounded = Math.round(value * 100.0) / 100.0;
                bankAccount.deposit(rounded);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable withdrawTask = ()->{
            for(int i = 0; i<10;i++){
                double value = random.nextDouble(100);
                double rounded = Math.round(value * 100.0) / 100.0;
                bankAccount.withdraw(rounded);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread depositor = new Thread(depositTask);
        Thread withdrawer = new Thread(withdrawTask);

        depositor.start();
        withdrawer.start();

        try {
            depositor.join();
            withdrawer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Final Balance: "+bankAccount.getBalance());
    }
}

class BankAccount{
    private double balance;

    public BankAccount(double balance){
        this.balance = balance;
    }
    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount){
        this.balance = this.balance + amount;
        System.out.println("Deposited: "+amount+" Total Balance: "+this.balance);
    }

    public synchronized void withdraw(double amount){
        if(this.balance - amount < 0)
            System.out.println("Insufficient Balance");
        else{
            this.balance = this.balance - amount;
            System.out.println("Withdrawn: "+amount+" Total Balance: "+this.balance);
        }
    }
}
