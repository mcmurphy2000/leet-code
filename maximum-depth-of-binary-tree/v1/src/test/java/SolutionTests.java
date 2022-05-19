import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork() {
        int result = tested.maxDepth(null);
        assertEquals(0, result);
    }

    @Test
    public void shouldWork1() {
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

        int result = tested.maxDepth(root);

        assertEquals(3, result);
    }

    @Test
    public void shouldWork2() {
        /*
                 1
                  \
                   2
         */
        TreeNode tn2 = new TreeNode(2);
        TreeNode root = new TreeNode(1, null, tn2);

        int result = tested.maxDepth(root);

        assertEquals(2, result);
    }
}
