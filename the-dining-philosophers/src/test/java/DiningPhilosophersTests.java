import org.junit.Test;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DiningPhilosophersTests {

    private final DiningPhilosophers diningPhilosophers = new DiningPhilosophers();
    private final EatCommand eatCommand = new EatCommand(diningPhilosophers);
    private final Queue<Operation> queue = new ConcurrentLinkedQueue<>();
    private final Philosopher p0 = new Philosopher(0, queue);
    private final Philosopher p1 = new Philosopher(1, queue);
    private final Philosopher p2 = new Philosopher(2, queue);
    private final Philosopher p3 = new Philosopher(3, queue);
    private final Philosopher p4 = new Philosopher(4, queue);

    @Test
    public void shouldWork() throws InterruptedException, InconsistencyException {
        int times = 5;
        ExecutorService s0 = schedule(times, () -> eatCommand.commandToEat(p0));
        ExecutorService s1 = schedule(times, () -> eatCommand.commandToEat(p1));
        ExecutorService s2 = schedule(times, () -> eatCommand.commandToEat(p2));
        ExecutorService s3 = schedule(times, () -> eatCommand.commandToEat(p3));
        ExecutorService s4 = schedule(times, () -> eatCommand.commandToEat(p4));
        s0.awaitTermination(10, TimeUnit.SECONDS);
        s1.awaitTermination(10, TimeUnit.SECONDS);
        s2.awaitTermination(10, TimeUnit.SECONDS);
        s3.awaitTermination(10, TimeUnit.SECONDS);
        s4.awaitTermination(10, TimeUnit.SECONDS);

        OperationAnalyzer analyzer = new OperationAnalyzer(queue);
        assertTrue(analyzer.isFine());

        Map<Integer, Integer> counts = analyzer.getEatCounts();
        assertFalse(counts.values().stream().anyMatch(count -> count != times));
    }

    private ExecutorService schedule(int times, Runnable r) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        IntStream.range(0, times)
                .forEach(time -> service.submit(r));
        service.shutdown();
        return service;
    }
}
