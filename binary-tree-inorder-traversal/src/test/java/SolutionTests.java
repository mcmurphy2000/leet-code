import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork() {
        List<Integer> result = tested.inorderTraversal(null);
        assertEquals(0, result.size());
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

        List<Integer> result = tested.inorderTraversal(root);
        assertEquals(5, result.size());
        assertEquals(Arrays.asList(9, 3, 15, 20, 7), result);
    }

    @Test
    public void shouldWork2() {
        /*
                 1
                  \
                  2
                 /
                3
         */
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn2 = new TreeNode(2, tn3, null);
        TreeNode root = new TreeNode(1, null, tn2);

        List<Integer> result = tested.inorderTraversal(root);
        assertEquals(3, result.size());
        assertEquals(Arrays.asList(1, 3, 2), result);
    }

    @Test
    public void shouldWork3() {
        /*
                 1
         */
        TreeNode root = new TreeNode(1);

        List<Integer> result = tested.inorderTraversal(root);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList(1), result);
    }

    @Test
    public void shouldWork4() {
        /*
                 1
                /
               2
         */
        TreeNode tn2 = new TreeNode(2);
        TreeNode root = new TreeNode(1, tn2, null);

        List<Integer> result = tested.inorderTraversal(root);
        assertEquals(2, result.size());
        assertEquals(Arrays.asList(2, 1), result);
    }

    @Test
    public void shouldWork5() {
        /*
                 1
                  \
                  2
         */
        TreeNode tn2 = new TreeNode(2);
        TreeNode root = new TreeNode(1, null, tn2);

        List<Integer> result = tested.inorderTraversal(root);
        assertEquals(2, result.size());
        assertEquals(Arrays.asList(1, 2), result);
    }
}
