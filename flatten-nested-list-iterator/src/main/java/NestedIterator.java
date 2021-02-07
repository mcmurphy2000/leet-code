import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
public class NestedIterator implements Iterator<Integer> {

    private final Deque<Iterator<NestedInteger>> stack = new ArrayDeque<>();
    private Iterator<NestedInteger> currentIterator;
    NestedInteger currentInteger;

    public NestedIterator(List<NestedInteger> nestedList) {
        currentIterator = nestedList.iterator();
        goUpDown();
    }

    @Override
    public Integer next() {
        Integer integer = currentInteger.getInteger();
        goUpDown();
        return integer;
    }

    @Override
    public boolean hasNext() {
        return currentInteger != null && currentInteger.isInteger();
    }

    private void goUp() {
        while (!currentIterator.hasNext() && !stack.isEmpty()) {
            currentIterator = stack.pop();
        }
    }

    private void goUpDown() {
        currentInteger = null;
        goUp();
        while (currentIterator.hasNext() && !(currentInteger = currentIterator.next()).isInteger()) {
            stack.push(currentIterator);
            currentIterator = currentInteger.getList().iterator();
            goUp();
        }
    }
}
