public class rangeSumQuery2d308 {

    class NumMatrix {
        private int[][] mat, bit;
        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return;
            int m = matrix.length, n = matrix[0].length;
            mat = new int[m][n];
            bit = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    update(i, j, matrix[i][j]);
                }
            }
        }

        public void update(int row, int col, int val) {
            int diff = val - mat[row + 1][col + 1];
            for (int i = row + 1; i < mat.length; i += i& -i) {
                for (int j = col + 1; j < mat[i].length; j += j& -j) {
                    bit[i][j] += diff;
                }
            }
            mat[row + 1][col + 1] = val;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return getSum(row2 + 1, col2 + 1) + getSum(row1, col1) -
                    getSum(row1, col2 + 1) - getSum(row2 + 1, col1);
        }
        private int getSum(int row, int col) {
            int res = 0;
            for (int i = row; i > 0; i -= i &- i) {
                for (int j = col; j > 0; j -= j &-j) {
                    res += bit[i][j];
                }
            }
            return res;
        }
    }

}
