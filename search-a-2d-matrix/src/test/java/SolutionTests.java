import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork1() {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        boolean expected = true;

        assertEquals(expected, tested.searchMatrix(matrix, target));
    }

    @Test
    public void shouldWork2() {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        boolean expected = false;

        assertEquals(expected, tested.searchMatrix(matrix, target));
    }
}
