import java.util.Deque;
import java.util.LinkedList;

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> pPath = findPath(root, p);
        Deque<TreeNode> qPath = findPath(root, q);
        return commonAncestor(pPath, qPath);
    }

    private Deque<TreeNode> findPath(TreeNode root, TreeNode node) {
        Deque<TreeNode> stack = new LinkedList<>();
        traversePreOrder(root, node, stack);
        return stack;
    }

    private boolean traversePreOrder(TreeNode node, TreeNode targetNode, Deque<TreeNode> stack) {
        if (node == null) return false;
        if (node.equals(targetNode)) {
            stack.push(node);
            return true;
        }
        if (traversePreOrder(node.left, targetNode, stack) || traversePreOrder(node.right, targetNode, stack)) {
            stack.push(node);
            return true;
        }
        return false;
    }

    private TreeNode commonAncestor(Deque<TreeNode> stack1, Deque<TreeNode> stack2) {
        TreeNode commonAncestor = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode n1 = stack1.pop();
            TreeNode n2 = stack2.pop();
            if (n1.equals(n2)) {
                commonAncestor = n1;
            } else {
                break;
            }
        }
        return commonAncestor;
    }
}