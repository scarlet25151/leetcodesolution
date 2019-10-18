import java.util.Arrays;

public class knightDIaler935 {
    public int knightDialer(int N) {
        int[][] dirs = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9},
                {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        int[] dp = new int[10];
        int[] dp1 = new int[10];
        Arrays.fill(dp, 1);
        int M = (int) 1e9+7;

        while (--N > 0) {
            for (int i = 0; i < 10; i++) {
                for (int dir : dirs[i]) {
                    dp1[i] = (dp[dir] + dp1[i]) % M;
                }
            }
            dp = dp1;
            dp1 = new int[10];
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = (res + dp[i]) % M;
        }
        return res;
    }
}
