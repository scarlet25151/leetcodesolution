public class paintHouse {
    public int minCost(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) return 0;
        int[][] dp = costs;
        int colorNum = costs[0].length;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < colorNum; j++) {
                dp[i][j] += Math.min(dp[i - 1][(j + 1) % colorNum],
                        dp[i - 1][(j + 2) % 3]);
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < colorNum; i++) {
            res = Math.min(res, dp[dp.length - 1][i]);
        }
        return res;
    }
}
