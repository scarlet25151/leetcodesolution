import java.util.*;

public class wordBreakII140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> map = new HashMap<>();
        return dfs(s, wordDict, map, 0);
    }
    private List<String> dfs(String s, List<String> wordDict,
                             Map<Integer, List<String>> map,
                             int start) {
        if (map.containsKey(start))
            return map.get(start);
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length())
            res.add("");
        for (int end = start + 1; end <= s.length(); ++end) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = dfs(s, wordDict, map, end);
                for (String word : list)
                    res.add(s.substring(start, end) +
                            (word.length() == 0 ? "" : " ") + word);
                
            }
        }
        map.put(start, res);
        return res;
    }
    public List<String> wordBreak_dp(String s, List<String> wordDict) {
        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
        LinkedList<String> initial = new LinkedList<>();
        initial.add("");
        dp[0] = initial;
        for (int i = 1; i < s.length(); i++) {
            LinkedList<String> list = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                    for (String l : dp[j]) {
                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
                    }
                }
            }
            dp[i] = list;
        }
        return dp[s.length()];
    }
}
