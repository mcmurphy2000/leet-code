import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class H2OTests {

    private final H2O tested = new H2O();

    @Test
    public void shouldWork() throws InterruptedException {
        Queue<Character> queue = new ConcurrentLinkedDeque<>();
        Runnable h = () -> queue.offer('H');
        Runnable o = () -> queue.offer('O');

        ExecutorService serviceH = Executors.newSingleThreadExecutor();
        ExecutorService serviceO = Executors.newSingleThreadExecutor();
        IntStream.range(0, 10).forEach(i -> serviceH.submit(() -> {
            try {
                tested.hydrogen(h);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        IntStream.range(0, 5).forEach(i -> serviceO.submit(() -> {
            try {
                tested.oxygen(o);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        serviceH.shutdown();
        serviceO.shutdown();
        serviceH.awaitTermination(4, TimeUnit.SECONDS);
        serviceO.awaitTermination(4, TimeUnit.SECONDS);

        while (!queue.isEmpty()) {
            List<Character> h2o = new ArrayList<>(3);
            h2o.add(queue.poll());
            h2o.add(queue.poll());
            h2o.add(queue.poll());
            long hCount = h2o.stream()
                    .filter(c -> c.equals('H'))
                    .count();
            long oCount = h2o.stream()
                    .filter(c -> c.equals('O'))
                    .count();
            assertEquals(2, hCount);
            assertEquals(1, oCount);
        }
    }
}
