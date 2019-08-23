public class minimum_path_sum_64 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        int R = grid.length, C = grid[0].length;
        int[][] dp = new int[R][C];
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                dp[i][j] = 0;
            }
        }
        for (int i = 0; i < R; ++i) {
            dp[i][0] = grid[i][0];
        }
        for (int j = 0; j < C; ++j) {
            dp[0][j] = grid[0][j];
        }
        for (int i = 1; i < R; ++i) {
            for (int j = 1; j < C; ++j) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[R - 1][C - 1];
    }
}
