/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class LastVisited {
    int val;
    boolean initialized = false;
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        LastVisited lastVisited = new LastVisited();
        return traverseInOrder(root, lastVisited);
    }

    private boolean traverseInOrder(TreeNode node, LastVisited lastVisited) {
        if (node == null) return true;
        if (!traverseInOrder(node.left, lastVisited)) return false;
        if (lastVisited.initialized) {
            if (node.val <= lastVisited.val) return false;
        } else
            lastVisited.initialized = true;
        lastVisited.val = node.val;
        return traverseInOrder(node.right, lastVisited);
    }
}