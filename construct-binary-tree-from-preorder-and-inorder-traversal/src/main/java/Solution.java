import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

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
class Solution {

    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        final Map<Integer, Integer> inorderValueIndexMap = IntStream.range(0, inorder.length)
                .boxed()
                .collect(toMap(i -> inorder[i], Function.identity()));
        preorderIndex = 0;
        return toTree(preorder, inorderValueIndexMap, 0, preorder.length);
    }

    // from - inclusive
    // to - exclusive
    private TreeNode toTree(int[] preorder, Map<Integer, Integer> inorderValueIndexMap, int from, int to) {
        if (from >= to) return null;

        final TreeNode root = new TreeNode(preorder[preorderIndex]);
        preorderIndex++;

        int rootIndex = inorderValueIndexMap.get(root.val);
        root.left = toTree(preorder, inorderValueIndexMap, from, rootIndex);
        root.right = toTree(preorder, inorderValueIndexMap, rootIndex + 1, to);

        return root;
    }
}