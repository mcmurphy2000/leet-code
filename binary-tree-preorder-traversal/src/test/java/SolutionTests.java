import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private Solution tested = new Solution();

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

        List<Integer> result = tested.preorderTraversal(root);
        assertEquals(3, result.size());
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    public void shouldWork2() {
        List<Integer> result = tested.preorderTraversal(null);
        assertEquals(0, result.size());
    }

    @Test
    public void shouldWork3() {
        /*
                 1
         */
        TreeNode root = new TreeNode(1);

        List<Integer> result = tested.preorderTraversal(root);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList(1), result);
    }
}
