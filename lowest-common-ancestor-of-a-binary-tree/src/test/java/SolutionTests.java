import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork() {
        /*
                    3
                  /  \
                /     \
               5       1
              / \    /  \
             6   2  0    8
                / \
               7   4
         */
        TreeNode tn7 = new TreeNode(7);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn6 = new TreeNode(6);
        TreeNode tn2 = new TreeNode(2, tn7, tn4);
        TreeNode tn5 = new TreeNode(5, tn6, tn2);
        TreeNode tn0 = new TreeNode(0);
        TreeNode tn8 = new TreeNode(8);
        TreeNode tn1 = new TreeNode(1, tn0, tn8);
        TreeNode root = new TreeNode(3, tn5, tn1);

        assertEquals(root, tested.lowestCommonAncestor(root, tn5, tn1));
        assertEquals(tn5, tested.lowestCommonAncestor(tn5, tn5, tn4));
    }
}
