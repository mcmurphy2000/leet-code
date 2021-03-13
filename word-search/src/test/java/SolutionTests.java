import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork() {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";

        assertTrue(tested.exist(board, word));
    }

    @Test
    public void shouldWork1() {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";

        assertTrue(tested.exist(board, word));
    }

    @Test
    public void shouldWork2() {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";

        assertFalse(tested.exist(board, word));
    }
}
