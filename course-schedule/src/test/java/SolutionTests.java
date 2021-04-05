import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {
        int[] prerequisite1 = {1, 0};
        int[][] prerequisites = {prerequisite1};
        int numCourses = 2;
        boolean expected = true;

        assertEquals(expected, tested.canFinish(numCourses, prerequisites));
    }

    @Test
    public void shouldWork2() {
        int[] prerequisite1 = {1, 0};
        int[] prerequisite2 = {0, 1};
        int[][] prerequisites = {prerequisite1, prerequisite2};
        int numCourses = 2;
        boolean expected = false;

        assertEquals(expected, tested.canFinish(numCourses, prerequisites));
    }
}
