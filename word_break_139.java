import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class word_break_139 {
    public boolean wordBreak_memoSearch(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return check(s, wordSet, 0, memo);
    }
    private boolean check(String s, Set<String> wordSet,
                          int start, int[] memo) {
        if (start >= s.length()) return true;
        if (memo[start] != -1) return memo[start] == 1;
        for (int i = start + 1; i < s.length(); ++i) {
            if (wordSet.contains(s.substring(start, i))
                    && check(s, wordSet, i, memo)) {
                return memo[start] == 1;
            }
        }
        return memo[start] == 0;
    }
    public boolean wordBreak_dp(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && wordSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
