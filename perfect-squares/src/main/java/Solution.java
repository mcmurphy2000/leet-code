import java.util.LinkedList;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.TreeSet;

class Node {
    final int depth;
    final int sum;
    final int value;

    public Node(int value, int depth, int sum) {
        this.depth = depth;
        this.sum = sum;
        this.value = value;
    }
}

public class Solution {

    public int numSquares(int n) {
        NavigableSet<Integer> perfects = getPerfectSquares(n);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(n, 0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.sum == n) return node.depth;
            int reminder = n - node.sum;
            perfects.headSet(reminder, true).descendingSet().stream()
                    .filter(i -> node.sum + i <= n)
                    .forEach(i -> queue.offer(new Node(i, node.depth + 1, node.sum + i)));
        }
        return -1;
    }

    private NavigableSet<Integer> getPerfectSquares(int n) {
        NavigableSet<Integer> result = new TreeSet<>();
        int sqrt = (int)Math.sqrt(n);
        int i = 1;
        while (i <= sqrt) {
            result.add((int)Math.pow(i, 2));
            i++;
        }
        return result;
    }
}
