import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork() {
        List<Integer> result = tested.postorderTraversal(null);
        assertEquals(0, result.size());
    }

    @Test
    public void shouldWork1() {
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

        List<Integer> result = tested.postorderTraversal(root);
        assertEquals(3, result.size());
        assertEquals(Arrays.asList(3, 2, 1), result);
    }

    @Test
    public void shouldWork2() {
        /*
                 1
         */
        TreeNode root = new TreeNode(1);

        List<Integer> result = tested.postorderTraversal(root);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList(1), result);
    }
}
