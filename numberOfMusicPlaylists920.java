public class numberOfMusicPlaylists920 {
    public int numMusicPlaylists(int N, int L, int K) {
        int M = 1000000007;
        int[][] dp = new int[L + 1][N + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= L; i++) {
            for (int j = 1;  j <= N; j++) {
                dp[i][j] += dp[i - 1][j - 1] * (N - j);
                dp[i][j] += dp[i - 1][j] * Math.max(j - K, 0);
                dp[i][j] %= M;
            }
        }
        return dp[L][N];
    }
}
