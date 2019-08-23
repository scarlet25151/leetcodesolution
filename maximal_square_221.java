import java.util.*;

public class maximal_square_221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int res = 0, h = matrix.length, w = matrix[0].length;
        int dp[][] = new int[h][w];
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                if (i == 0 || j == 0)
                    dp[i][j] = matrix[i][j] - '0';
                else if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }
}
