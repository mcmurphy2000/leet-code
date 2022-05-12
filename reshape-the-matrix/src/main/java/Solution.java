class Solution {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length == 0) {
            return mat;
        }
        int r0 = mat.length;
        int c0 = mat[0].length;
        if (r * c != r0 * c0) {
            return mat;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            res[i / c][i % c] = mat[i / c0][i % c0];
        }
        return res;
    }
}