import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {
        /*
                 3
                / \
               9  20
                 /  \
                15   7
         */
        TreeNode tn15 = new TreeNode(15);
        TreeNode tn7 = new TreeNode(7);
        TreeNode tn20 = new TreeNode(20, tn15, tn7);
        TreeNode tn9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, tn9, tn20);
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        assertEquals(root, tested.buildTree(preorder, inorder));
    }

    @Test
    public void shouldWork2() {
        /*
                 -1
         */
        TreeNode root = new TreeNode(-1);
        int[] preorder = {-1};

        int[] inorder = {-1};

        assertEquals(root, tested.buildTree(preorder, inorder));
    }
}
