import java.util.Map;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

class InconsistencyException extends Exception {}

class Fork {
    final int id;
    boolean picked = false;
    int pickedBy;

    public Fork(int id) {
        this.id = id;
    }

    void wasPicked(int byId) throws InconsistencyException {
        if (picked) throw new InconsistencyException();
        pickedBy = byId;
        picked = true;
    }

    void wasPut(int byId) throws InconsistencyException {
        if (!picked || pickedBy != byId) throw new InconsistencyException();
        picked = false;
    }
}

class Person {
    final int id;
    Fork leftFork;
    Fork rightFork;
    int eatCount = 0;

    public Person(int id) {
        this.id = id;
    }

    void pickedLeftFork(Fork fork) throws InconsistencyException {
        if (leftFork != null) throw new InconsistencyException();
        leftFork = fork;
    }

    void putLeftFork(Fork fork) throws InconsistencyException {
        if (leftFork == null || leftFork != fork) throw new InconsistencyException();
        leftFork = null;
    }

    void pickedRightFork(Fork fork) throws InconsistencyException {
        if (rightFork != null) throw new InconsistencyException();
        rightFork = fork;
    }

    void putRightFork(Fork fork) throws InconsistencyException {
        if (rightFork == null || rightFork != fork) throw new InconsistencyException();
        rightFork = null;
    }

    void hasEaten() throws InconsistencyException {
        if (leftFork == null || rightFork == null) throw new InconsistencyException();
        eatCount++;
    }

    public int getEatCount() {
        return eatCount;
    }
}

/**
 * 5 forks
 * 	each fork must be free before being picked up
 * 	each fork must have been picked by the same person who is putting it down
 *
 * person
 * 	must hold both forks when eating
 */
public class OperationAnalyzer {

    private static final int OBJECT_COUNT = 5;

    private final Queue<Operation> queue;
    // key - id
    private final Map<Integer, Fork> forks = IntStream.range(0, OBJECT_COUNT).boxed().collect(toMap(Function.identity(), Fork::new));
    // key - id
    private final Map<Integer, Person> persons = IntStream.range(0, OBJECT_COUNT).boxed().collect(toMap(Function.identity(), Person::new));

    public OperationAnalyzer(Queue<Operation> queue) {
        this.queue = queue;
    }

    public boolean isFine() throws InconsistencyException {
        while (!queue.isEmpty()) {
            Operation op = queue.poll();
            Person person = persons.get(op.id);

            switch (op.operation) {
                case 1:
                    Fork fork;
                    if (op.fork == 1) {
                        fork = getLeftFork(op.id);
                        person.pickedLeftFork(fork);
                    } else {
                        fork = getRightFork(op.id);
                        person.pickedRightFork(fork);
                    }
                    fork.wasPicked(op.id);
                    break;
                case 2:
                    if (op.fork == 1) {
                        fork = getLeftFork(op.id);
                        person.putLeftFork(fork);
                    } else {
                        fork = getRightFork(op.id);
                        person.putRightFork(fork);
                    }
                    fork.wasPut(op.id);
                    break;
                case 3:
                    person.hasEaten();
                    break;
                default:
                    throw new InconsistencyException();
            }
        }
        return true;
    }

    /**
     * key - id
     * value - eat count
     */
    public Map<Integer, Integer> getEatCounts() {
        return persons.entrySet().stream()
                .collect(toMap(Map.Entry::getKey, entry -> entry.getValue().getEatCount()));
    }

    // person owns a fork to their left
    private Fork getLeftFork(int id) {
        return forks.get(id);

    }

    // person owns a fork to their left
    private Fork getRightFork(int id) {
        int forkId = id - 1 >= 0 ? id - 1 : OBJECT_COUNT - 1;
        return forks.get(forkId);
    }
}
