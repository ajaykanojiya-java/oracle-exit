public class OddEvenThreads {

    int MAX = 100;
    private int number = 1;
    public synchronized void printOdd() {
        while(number<=MAX){
            if (number%2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                System.out.println(Thread.currentThread().getName()+"  "+number);
                number++;
                notify();
            }
        }
    }

    public synchronized void printEven() {
        while(number<=MAX){
            if (number%2 == 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                System.out.println(Thread.currentThread().getName()+" "+number);
                number++;
                notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OddEvenThreads oddEvenThreads = new OddEvenThreads();
        Thread t1 = new Thread(()->oddEvenThreads.printOdd(),"Odd-Thread");
        Thread t2 = new Thread(()->oddEvenThreads.printEven(),"Even-Thread");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("End");
    }
}
