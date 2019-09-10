import java.util.Arrays;

public class longestPalindromicSubsequence516 {
    public int longestPalindromeSubseq_dp(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; --i) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
    public int longestPalindromeSubseq_memo(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];
        for(int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return dfs(s, 0, n - 1, memo);
    }
    private int dfs(String s, int i, int j, int[][] memo) {
        if (memo[i][j] != -1) return memo[i][j];
        if (i > j) return 0;
        if (i == j) return 1;
        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = dfs(s, i + 1, j - 1, memo) + 2;
        } else {
            memo[i][j] = Math.max(dfs(s, i + 1, j, memo), dfs(s, i, j + 1, memo));
        }
        return memo[i][j];
    }
}
