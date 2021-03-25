import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {
        boolean expected = true;

        boolean result = tested.isValidBST(null);

        assertEquals(expected, result);
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
        boolean expected = false;

        boolean result = tested.isValidBST(root);

        assertEquals(expected, result);
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
        boolean expected = false;

        boolean result = tested.isValidBST(root);

        assertEquals(expected, result);
    }

    @Test
    public void shouldWork3() {
        /*
                 1
         */
        TreeNode root = new TreeNode(1);
        boolean expected = true;

        boolean result = tested.isValidBST(root);

        assertEquals(expected, result);
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
        boolean expected = false;

        boolean result = tested.isValidBST(root);

        assertEquals(expected, result);
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
        boolean expected = true;

        boolean result = tested.isValidBST(root);

        assertEquals(expected, result);
    }

    @Test
    public void shouldWork6() {
        /*
                 2
               /  \
              1    3
         */
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn3 = new TreeNode(3);
        TreeNode root = new TreeNode(2, tn1, tn3);
        boolean expected = true;

        boolean result = tested.isValidBST(root);

        assertEquals(expected, result);
    }

    @Test
    public void shouldWork7() {
        /*
                 5
                / \
               1   4
                  / \
                 3   6
         */
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn6 = new TreeNode(6);
        TreeNode tn4 = new TreeNode(4, tn3, tn6);
        TreeNode root = new TreeNode(5, tn1, tn4);
        boolean expected = false;

        boolean result = tested.isValidBST(root);

        assertEquals(expected, result);
    }

    @Test
    public void shouldWork8() {
        /*
                 -2147483648
         */
        TreeNode root = new TreeNode(-2147483648);
        boolean expected = true;

        boolean result = tested.isValidBST(root);

        assertEquals(expected, result);
    }
}
