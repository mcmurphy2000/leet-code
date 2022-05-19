import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NodeWithLevel {
    TreeNode node;
    int level;  // 0 - based
    boolean visited = false;
    NodeWithLevel(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<NodeWithLevel> queue = new LinkedList<>();
        enqueue(new NodeWithLevel(root, 0), queue);

        while (!queue.isEmpty()) {
            NodeWithLevel node = queue.poll();
            if (result.size() <= node.level) {
                result.add(new ArrayList<>());
            }
            result.get(node.level).add(node.node.val);

            enqueue(new NodeWithLevel(node.node.left, node.level + 1), queue);
            enqueue(new NodeWithLevel(node.node.right, node.level + 1), queue);
        }

        return result;
    }

    private void enqueue(NodeWithLevel node, Queue<NodeWithLevel> queue) {
        if (!node.visited && node.node != null) {
            queue.add(node);
            node.visited = true;
        }
    }
}
