import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    private static final int BOX_SIZE = 3;

    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        if (rows == 0) return false;
        int cols = board[0].length;
        if (cols == 0) return false;

        // key - column number, zero based
        Map<Integer, Set<Integer>> colMap = new HashMap<>();
        // key - box index, zero based
        Map<Integer, Set<Integer>> boxMap = new HashMap<>();
        for (int row = 0; row < rows; row++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int col = 0; col < cols; col++) {
                int digit = validDigit(board[row][col]);
                if (digit != -1) {
                    if (rowSet.contains(digit)) return false;
                    rowSet.add(digit);

                    Set<Integer> colSet = colMap.computeIfAbsent(col, k -> new HashSet<>());
                    if (colSet.contains(digit)) return false;
                    colSet.add(digit);

                    int boxIndex = getBoxIndex(row, col, rows, cols);
                    Set<Integer> boxSet = boxMap.computeIfAbsent(boxIndex, k -> new HashSet<>());
                    if (boxSet.contains(digit)) return false;
                    boxSet.add(digit);
                }
            }
        }
        return true;
    }

    private int validDigit(char chr) {
        int digit = Character.getNumericValue(chr);
        return digit >=1 && digit <= 9 ? digit : -1;
    }

    private int getBoxIndex(int row, int col, int rows, int cols) {
        int boxCols = cols / BOX_SIZE;
        int boxRow = row / BOX_SIZE;
        int boxCol = col / BOX_SIZE;
        return boxRow * boxCols + boxCol;
    }
}