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
        boolean expected = true;

        boolean result = tested.isSymmetric(root);

        assertEquals(expected, result);
    }

    @Test
    public void shouldWork2() {
        /*
                  1
                 /  \
               2     2
              / \   / \
             3   4 4   3
         */
        TreeNode tn2_1 = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode tn2_2 = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        TreeNode root = new TreeNode(1, tn2_1, tn2_2);
        boolean expected = true;

        boolean result = tested.isSymmetric(root);

        assertEquals(expected, result);
    }

    @Test
    public void shouldWork3() {
        /*
                  1
                 /  \
               2     2
                \     \
                 3     3
         */
        TreeNode tn2_1 = new TreeNode(2, null, new TreeNode(3));
        TreeNode tn2_2 = new TreeNode(2, null, new TreeNode(3));
        TreeNode root = new TreeNode(1, tn2_1, tn2_2);
        boolean expected = false;

        boolean result = tested.isSymmetric(root);

        assertEquals(expected, result);
    }
}
