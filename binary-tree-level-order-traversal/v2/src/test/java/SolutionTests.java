import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork() {
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

        List<List<Integer>> result = tested.levelOrder(root);
        assertEquals(3, result.size());
        assertEquals(Arrays.asList(3), result.get(0));
        assertEquals(Arrays.asList(9, 20), result.get(1));
        assertEquals(Arrays.asList(15, 7), result.get(2));
    }

    @Test
    public void shouldWork2() {
        List<List<Integer>> result = tested.levelOrder(null);
        assertEquals(0, result.size());
    }

}
