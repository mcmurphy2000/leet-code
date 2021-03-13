import java.util.HashMap;
import java.util.Map;

class Solution {

    private Map<Integer, Integer> cache;
    private int rows;
    private int columns;

    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) return 1; // wtf?
        cache = new HashMap<>();
        rows = m;
        columns = n;
        return uniquePathsRecursive(0, 0);
    }

    // row and col are zero based
    private int uniquePathsRecursive(int row, int col) {
        int index = getIndex(row, col);
        if (index == -1) return 0;
        Integer cachedPaths = cache.get(index);
        if (cachedPaths != null)
            return cachedPaths;

        if (row == rows - 1 && col == columns - 2) return 1;
        if (row == rows - 2 && col == columns - 1) return 1;

        int down = uniquePathsRecursive(row + 1, col);
        int right = uniquePathsRecursive(row, col + 1);
        int paths = down + right;
        cache.put(index, paths);
        return paths;
    }

    private int getIndex(int row, int col) {
        if (row >= rows || col >= columns) return -1;
        return row * columns + col;
    }
}