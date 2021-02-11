import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FooBarTests {

    @Test
    public void shouldWork() throws InterruptedException {
        Runnable printFoo = () -> System.out.print("foo");
        Runnable printBar = () -> System.out.println("bar");
        FooBar tested = new FooBar(10);
        Runnable r1 = () -> {
            try {
                tested.foo(printFoo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r2 = () -> {
            try {
                tested.bar(printBar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(r1);
        service.submit(r2);
        service.shutdown();
        service.awaitTermination(3, TimeUnit.SECONDS);
    }
}
