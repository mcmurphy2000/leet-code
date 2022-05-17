import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
class MyQueue {

    private final Deque<Integer> stack1;
    private final Deque<Integer> stack2;

    public MyQueue() {
        // stack1 will be for push
        // stack2 will be for pop and peek
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        refill(stack2, stack1);
        stack1.push(x);
    }

    public int pop() {
        refill(stack1, stack2);
        return stack2.pop();
    }

    public int peek() {
        refill(stack1, stack2);
        return Objects.requireNonNullElse(stack2.peek(), -1);
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void refill(Deque<Integer> source, Deque<Integer> target) {
        while (!source.isEmpty()) {
            target.push(source.pop());
        }
    }
}
