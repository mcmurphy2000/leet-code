public class Operation {
    /**
     * is the id of a philosopher.
     */
    public final int id;
    /**
     * specifies the fork: {1 : left, 2 : right}.
     */
    public final int fork;
    /**
     * specifies the operation: {1 : pick, 2 : put, 3 : eat}.
     */
    public final int operation;

    public Operation(int id, int fork, int operation) {
        this.id = id;
        this.fork = fork;
        this.operation = operation;
    }
}
