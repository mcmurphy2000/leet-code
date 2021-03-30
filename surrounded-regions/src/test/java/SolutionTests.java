import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {
        int[] a = {1, 2};
        int[] b = {-2,-1};
        int[] c = {-1, 2};
        int[] d = {0, 2};
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        char[][] expected = {
                {'X','X','X','X'},
                {'X','X','X','X'},
                {'X','X','X','X'},
                {'X','O','X','X'}
        };

        tested.solve(board);
        
        assertArrayEquals(expected, board);
    }

    @Test
    public void shouldWork1() {
        int[] a = {1, 2};
        int[] b = {-2,-1};
        int[] c = {-1, 2};
        int[] d = {0, 2};
        char[][] board = {
                {'X'}
        };
        char[][] expected = {
                {'X'}
        };

        tested.solve(board);

        assertArrayEquals(expected, board);
    }
}
