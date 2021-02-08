import java.util.function.IntConsumer;

public class FizzBuzz {

    private int n;
    private volatile boolean fizz;
    private volatile boolean buzz;
    private volatile boolean done;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (!done) {
            while (!fizz || buzz) {
                wait();
                if (done) return;
            }
            fizz = false;
            printFizz.run();
            notifyAll();
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (!done) {
            while (!buzz || fizz) {
                wait();
                if (done) return;
            }
            buzz = false;
            printBuzz.run();
            notifyAll();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (!done) {
            while (!(buzz && fizz)) {
                wait();
                if (done) return;
            }
            fizz = false;
            buzz = false;
            printFizzBuzz.run();
            notifyAll();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) fizz = true;
            if (i % 5 == 0) buzz = true;
            if (!fizz && !buzz) {
                printNumber.accept(i);
            }
            notifyAll();
            while (buzz || fizz) {
                wait();
            }
        }
        done = true;
        notifyAll();
    }
}
