import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork1() {
        /*
        Input:
                  4
                 /  \
               2     7
              / \
             1   3

         Output:
                  4
                 /  \
               2     7
              / \   /
             1   3 5
         */
        TreeNode tn2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode tn7 = new TreeNode(7);
        TreeNode root = new TreeNode(4, tn2, tn7);
        int val = 5;
        TreeNode tn2e = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode tn7e = new TreeNode(7, new TreeNode(5), null);
        TreeNode expected = new TreeNode(4, tn2e, tn7e);

        TreeNode result = tested.insertIntoBST(root, val);

        assertEquals(expected, result);
    }
}
