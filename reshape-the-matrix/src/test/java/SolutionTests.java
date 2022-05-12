import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork1() {
        int[][] mat = {{1,2},{3,4}};
        int r = 1;
        int c = 4;
        int[][] expected = {{1,2,3,4}};

        assertArrayEquals(expected, tested.matrixReshape(mat, r, c));
    }

    @Test
    public void shouldWork2() {
        int[][] mat = {{1,2},{3,4}};
        int r = 2;
        int c = 2;
        int[][] expected = {{1,2},{3,4}};

        assertArrayEquals(expected, tested.matrixReshape(mat, r, c));
    }
}
