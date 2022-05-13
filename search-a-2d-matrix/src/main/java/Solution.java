class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (cols == 0) return false;
        return binarySearch(matrix, target, 0, rows * cols) != -1;
    }

    // from - inclusive
    // to - exclusive
    // returns index or -1 if not found
    private int binarySearch(int[][] matrix, int target, int from, int to) {
        if (to - from <= 1) {
            return getByIndex(matrix, from) == target ? from : -1;
        }
        int mid = (from + to) / 2;
        int el = getByIndex(matrix, mid);
        return target >= el
                ? binarySearch(matrix, target, mid, to)
                : binarySearch(matrix, target, from, mid);
    }

    private int getByIndex(int[][] matrix, int index) {
        int cols = matrix[0].length;
        int r = index / cols;
        int c = index % cols;
        return matrix[r][c];
    }
}