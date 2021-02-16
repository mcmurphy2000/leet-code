import java.util.Arrays;
import java.util.LinkedList;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.TreeSet;

class Node {
    final int value;
    final int sum;
    final int depth;

    public Node(int value, int sum, int depth) {
        this.value = value;
        this.sum = sum;
        this.depth = depth;
    }
}

class Solution {

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return 0;
        NavigableSet<Integer> nodeSet = new TreeSet<>();
        Arrays.stream(coins).forEach(nodeSet::add);

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(amount, 0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.sum == amount) return node.depth;
            int remaining = amount - node.sum;
            nodeSet.headSet(remaining, true).descendingSet().stream()
                    .filter(child -> node.sum + child <= amount)
                    .forEach(child -> queue.offer(new Node(child, node.sum + child, node.depth + 1)));
        }
        return -1;
    }
}