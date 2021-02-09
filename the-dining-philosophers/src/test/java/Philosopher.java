import java.util.Queue;

public class Philosopher {
    private final int id;
    private final Queue<Operation> queue;

    public Philosopher(int id, Queue<Operation> queue) {
        this.id = id;
        this.queue = queue;

    }

    public int getId() {
        return id;
    }

    public Runnable pickLeftFork() {
        return () -> queue.offer(new Operation(id, 1, 1));
    }

    public Runnable pickRightFork() {
        return () -> queue.offer(new Operation(id, 2, 1));
    }

    public Runnable putLeftFork() {
        return () -> queue.offer(new Operation(id, 1, 2));
    }

    public Runnable putRightFork() {
        return () -> queue.offer(new Operation(id, 2, 2));
    }

    public Runnable eat() {
        return () -> queue.offer(new Operation(id, 0, 3));
    }
}
