package multithreading;

/*
* Use 3 threads to print numbers in order:
Thread1 prints 1,4,7,10…
Thread2 prints 2,5,8,11…
Thread3 prints 3,6,9,12…

* Expected Output (first 12 numbers):
Thread1 → 1
Thread2 → 2
Thread3 → 3
Thread1 → 4
Thread2 → 5
* */
public class NumbersSequence {
    private static final int MAX = 12;          // how many numbers to print
    private static int number = 1;              // shared counter
    private static int turn = 1;                // whose turn (1, 2, or 3)
    public static void main(String[] args) {
        NumbersSequence numbersSequence = new NumbersSequence();
        Thread t1 = new Thread(()->numbersSequence.printNumbers(1),"Thread-1");
        Thread t2 = new Thread(()->numbersSequence.printNumbers(2),"Thread-2");
        Thread t3 = new Thread(()->numbersSequence.printNumbers(3),"Thread-3");

        t1.start();
        t2.start();
        t3.start();

    }
    private void printNumbers(int threadId){
        while(true){
            synchronized (this) {
                while (turn != threadId && number <= MAX) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                if (number > MAX) {
                    notifyAll();
                    break;
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                number++;
                turn = (turn % 3) + 1;
                notifyAll();
            }
        }
    }
}



