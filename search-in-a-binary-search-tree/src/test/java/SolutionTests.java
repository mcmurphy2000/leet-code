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
               2
              / \
             1   3
         */
        TreeNode tn2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode tn7 = new TreeNode(7);
        TreeNode root = new TreeNode(4, tn2, tn7);
        int val = 2;
        TreeNode expected = tn2;

        TreeNode result = tested.searchBST(root, val);

        assertEquals(expected, result);
    }

    @Test
    public void shouldWork2() {
        /*
        Input:
                  4
                 /  \
               2     7
              / \
             1   3

         Output:
               2
              / \
             1   3
         */
        TreeNode tn2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode tn7 = new TreeNode(7);
        TreeNode root = new TreeNode(4, tn2, tn7);
        int val = 5;
        TreeNode expected = null;

        TreeNode result = tested.searchBST(root, val);

        assertEquals(expected, result);
    }
}
