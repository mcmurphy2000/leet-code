import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;

public class ZeroEvenOddTests {

    @Test
    public void shouldWork() throws InterruptedException {
        IntConsumer zero = x -> System.out.print(x);
        IntConsumer even = x -> System.out.print(x);
        IntConsumer odd = x -> System.out.print(x);
        ZeroEvenOdd tested = new ZeroEvenOdd(7);
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(() -> {
            try {
                tested.zero(zero);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.submit(() -> {
            try {
                tested.even(even);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.submit(() -> {
            try {
                tested.odd(odd);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.shutdown();
        service.awaitTermination(5, TimeUnit.SECONDS);
    }
}
