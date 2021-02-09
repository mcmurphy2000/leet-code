import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

class DiningPhilosophers {

    private static final int PHILOSOPHERS_COUNT = 5;
    // key - id of left fork
    private final Map<Integer, Lock> leftForks;
    //private final FrequencyMap frequentEaters;
    private final Semaphore semaphore = new Semaphore(PHILOSOPHERS_COUNT - 1);

    public DiningPhilosophers() {
        leftForks = IntStream.range(0, PHILOSOPHERS_COUNT)
                .boxed()
                .collect(toMap(Function.identity(), id -> new ReentrantLock()));
        //frequentEaters = new FrequencyMap();
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        Lock leftFork = getLeftFork(philosopher);
        Lock rightFork = getRightFork(philosopher);
        semaphore.acquire();

        leftFork.lock();
        pickLeftFork.run();
        rightFork.lock();
        pickRightFork.run();

        eat(philosopher, eat);

        putLeftFork.run();
        leftFork.unlock();
        putRightFork.run();
        rightFork.unlock();

        semaphore.release();
    }

    private void eat(int id, Runnable eat) {
        eat.run();
        //frequentEaters.registerOccurrence(id);
    }

    /*
    private boolean isMostFrequentEater(int id) {
        Integer mostFrequent = frequentEaters.getMostFrequentId();
        return mostFrequent == null ? true : id == mostFrequent;
    }
     */

    private Lock getLeftFork(int id) {
        return leftForks.get(id);
    }

    private Lock getRightFork(int id) {
        int forkId = id - 1 >= 0 ? id - 1 : PHILOSOPHERS_COUNT - 1;
        return leftForks.get(forkId);
    }
}