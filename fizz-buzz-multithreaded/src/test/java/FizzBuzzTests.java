import org.junit.Test;

import java.util.function.IntConsumer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FizzBuzzTests {

    private FizzBuzz tested = new FizzBuzz(15);

    @Test
    public void shouldWork() throws InterruptedException {
        Runnable fizz = () -> {
            System.out.println("fizz");
        };
        Runnable buzz = () -> {
            System.out.println("buzz");
        };
        Runnable fizzbuzz = () -> {
            System.out.println("fizzbuzz");
        };
        IntConsumer consumer = i -> {
            System.out.println(i);
        };



        Thread t1 = new Thread(() -> {
            try {
                tested.fizz(fizz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                tested.buzz(buzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                tested.fizzbuzz(fizzbuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread t4 = new Thread(() -> {
            try {
                tested.number(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }
}
