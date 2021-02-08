import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NodeWithDepth {
    final int depth;
    final TreeNode node;

    public NodeWithDepth(int depth, TreeNode node) {
        this.depth = depth;
        this.node = node;
    }
}

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<NodeWithDepth> queue = new LinkedList<>();
        List<Integer> currentList = new ArrayList<>();
        result.add(currentList);

        enqueue(new NodeWithDepth(0, root), queue, currentList);
        int currentLevel = 1;
        while (!queue.isEmpty()) {
            NodeWithDepth depthNode = queue.poll();
            if (depthNode.depth != currentLevel && (depthNode.node.left != null || depthNode.node.right != null)) {
                currentLevel = depthNode.depth;
                currentList = new ArrayList<>();
                result.add(currentList);
            }
            enqueue(new NodeWithDepth(depthNode.depth + 1, depthNode.node.left), queue, currentList);
            enqueue(new NodeWithDepth(depthNode.depth + 1, depthNode.node.right), queue, currentList);
        }
        return result;
    }

    private void enqueue(NodeWithDepth depthNode, Queue<NodeWithDepth> queue, List<Integer> currentList) {
        if (depthNode.node != null) {
            queue.add(depthNode);
            currentList.add(depthNode.node.val);
        }
    }
}
