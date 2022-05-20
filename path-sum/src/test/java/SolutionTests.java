import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork1() {
        /*
                      5
                    /   \
                  4      8
                 /      / \
               11     13   4
              / \           \
             7   2           1
         */
        TreeNode tn11 = new TreeNode(11, new TreeNode(7), new TreeNode(2));
        TreeNode tn4_1 = new TreeNode(4, tn11, null);
        TreeNode tn13 = new TreeNode(13);
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn4_2 = new TreeNode(4, null, tn1);
        TreeNode tn8 = new TreeNode(8, tn13, tn4_2);
        TreeNode root = new TreeNode(5, tn4_1, tn8);
        int targetSum = 22;
        boolean expected = true;

        boolean result = tested.hasPathSum(root, targetSum);

        assertEquals(expected, result);
    }

    @Test
    public void shouldWork3() {
        /*
                  1
                 /  \
               2     3
         */
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        int targetSum = 5;
        boolean expected = false;

        boolean result = tested.hasPathSum(root, targetSum);

        assertEquals(expected, result);
    }
}
