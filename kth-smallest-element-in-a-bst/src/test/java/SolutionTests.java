import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork() {
        /*
                 3
                / \
               1   4
                \
                 2
         */
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn1 = new TreeNode(1, null, tn2);
        TreeNode tn4 = new TreeNode(4);
        TreeNode root = new TreeNode(3, tn1, tn4);

        assertEquals(1, tested.kthSmallest(root, 1));
    }

    @Test
    public void shouldWork2() {
        /*
                 5
                / \
               3   6
              /  \
             2    4
            /
           1
         */
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2, tn1, null);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn3 = new TreeNode(3, tn2, tn4);
        TreeNode tn6 = new TreeNode(6);
        TreeNode root = new TreeNode(3, tn3, tn6);

        assertEquals(3, tested.kthSmallest(root, 3));
    }
}
