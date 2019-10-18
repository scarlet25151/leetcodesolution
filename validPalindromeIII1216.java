public class validPalindromeIII1216 {
    private int isKPalDP(String str1, String str2, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    private String reverse(String str) {

        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }
    public boolean isValidPalindrome(String s, int k) {
        String revStr = reverse(s);
        int len = s.length();
        return (isKPalDP(s, revStr, len, len) <= k * 2);
    }
}
