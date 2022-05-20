import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork1() {
        /*
                  1
         */
        TreeNode root = new TreeNode(1);
        TreeNode expected = new TreeNode(1);

        TreeNode result = tested.invertTree(root);

        assertEquals(expected, result);
    }

    @Test
    public void shouldWork2() {
        /*
        Input:
                  4
                 /  \
               2     7
              / \   / \
             1   3 6   9

         Output:
                  4
                 /  \
               7     2
              / \   / \
             9   6 3   1
         */
        TreeNode tn2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode tn7 = new TreeNode(7, new TreeNode(6), new TreeNode(9));
        TreeNode root = new TreeNode(4, tn2, tn7);

        TreeNode tn7e = new TreeNode(7, new TreeNode(9), new TreeNode(6));
        TreeNode tn2e = new TreeNode(2, new TreeNode(3), new TreeNode(1));
        TreeNode expected = new TreeNode(4, tn7e, tn2e);

        TreeNode result = tested.invertTree(root);

        assertEquals(expected, result);
    }

    @Test
    public void shouldWork3() {
        /*
        Input:
               2
              / \
             1   3

         Output:
               2
              / \
             3   1
         */
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode expected = new TreeNode(2, new TreeNode(3), new TreeNode(1));

        TreeNode result = tested.invertTree(root);

        assertEquals(expected, result);
    }
}
