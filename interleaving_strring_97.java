import java.util.HashSet;
import java.util.Set;

public class interleaving_strring_97 {
    boolean isInterleave_dp(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int n1 = s1.length(), n2 = s2.length();
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        //situation that s2 == ""
        for (int i = 1; i <= n1; ++i) {
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        //situation that s1 == ""
        for (int j = 1; j <= n2; ++j) {
            dp[0][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
        }
        for (int i = 1; i <= n1; ++i) {
            for (int j = 1; j <= n2; ++j) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1 + j)) ||
                        (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1 + i));
            }
        }
        return dp[n1][n2];
    }
    boolean isInterleave_dfs(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        Set<Integer> set = new HashSet<>();
        return dfs(s1, 0, s2, 0, s3, 0, set);
    }
    boolean dfs(String s1, int i, String s2, int j, String s3, int k,
                Set<Integer> set) {
        int key = i * s3.length() + j;
        if (set.contains(key)) return false;
        if (i == s1.length()) return s2.substring(j).equals(s3.substring(k));
        if (j == s2.length()) return s1.substring(i).equals(s3.substring(k));
        if ((s1.charAt(i) == s3.charAt(k) && dfs(s1, i + 1, s2, j, s3, k + 1, set)) ||
                (s2.charAt(j) == s3.charAt(k) && dfs(s1, i, s2, j + 1, s3, k + 1, set)))
            set.add(key);
        return false;
    }


}
