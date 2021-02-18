import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {
        int[] prerequisite1 = {1, 0};
        int[][] prerequisites = {prerequisite1};

        assertArrayEquals(new int[]{0, 1}, tested.findOrder(2, prerequisites));
    }

    @Test
    public void shouldWork2() {
        int[] prerequisite1 = {1, 0};
        int[] prerequisite2 = {2, 0};
        int[] prerequisite3 = {3, 1};
        int[] prerequisite4 = {3, 2};
        int[][] prerequisites = {prerequisite1, prerequisite2, prerequisite3, prerequisite4};

        assertArrayEquals(new int[]{0, 1, 2, 3}, tested.findOrder(4, prerequisites));
    }

    @Test
    public void shouldWork3() {
        int[][] prerequisites = {};

        assertArrayEquals(new int[]{0}, tested.findOrder(1, prerequisites));
    }

    @Test
    public void shouldWork4() {
        int[] prerequisite1 = {1, 2};
        int[] prerequisite2 = {2, 1};
        int[][] prerequisites = {prerequisite1, prerequisite2};

        assertArrayEquals(new int[0], tested.findOrder(3, prerequisites));
    }

    @Test
    public void shouldWork5() {
        int[] prerequisite1 = {1, 0};
        int[] prerequisite2 = {2, 0};
        int[] prerequisite3 = {0, 2};
        int[][] prerequisites = {prerequisite1, prerequisite2, prerequisite3};

        assertArrayEquals(new int[0], tested.findOrder(3, prerequisites));
    }

    @Test
    public void shouldWork6() {
        int[] prerequisite1 = {1, 0};
        int[] prerequisite2 = {0, 2};
        int[] prerequisite3 = {2, 1};
        int[][] prerequisites = {prerequisite1, prerequisite2, prerequisite3};

        assertArrayEquals(new int[0], tested.findOrder(3, prerequisites));
    }
}
