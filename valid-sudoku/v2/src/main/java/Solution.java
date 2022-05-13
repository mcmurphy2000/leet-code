import java.util.HashSet;
import java.util.Set;

class Solution {

    private static final int CELLS = 9;
    private static final int ROWS = 9;
    private static final int COLS = 9;

    public boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < ROWS; r++) {
            if (isInvalid(board, r, 0, COLS)) return false;
        }
        for (int c = 0; c < COLS; c++) {
            if (isInvalid(board, 0, c, 1)) return false;
        }
        for (int r = 0; r < ROWS; r+=3) {
            for (int c = 0; c < COLS; c+=3) {
                if (isInvalid(board, r, c, 3)) return false;
            }
        }
        return true;
    }

    private boolean isInvalid(char[][] board, int r, int c, int cLen) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < CELLS; i++) {
            char ch = board[r + i / cLen][c + i % cLen];
            if (ch != '.' && !set.add(ch)) {
                return true;
            }
        }
        return false;
    }
}