import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class stickersToSpellWord691 {
    public int minStickers(String[] words, String target) {
        Map<String, Integer> memo = new HashMap<>();
        memo.put("", 0);

        int[][] stickers = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            stickers[i] = strToMap(words[i]);
        }
        return dfs(target, stickers, memo);
    }
    private int[] strToMap(String s) {
        int[] res = new int[26];
        for (char ch : s.toCharArray()) {
            res[ch - 'a'] ++;
        }
        return res;
    }
    private int dfs(String target, int[][] stickers, Map<String, Integer> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        int[] targetMap = strToMap(target);
        int minStick = Integer.MAX_VALUE;
        for (int[] sticker : stickers) {
            if (sticker[target.charAt(0) - 'a'] <= 0) {
                continue;
            }
            StringBuilder newTarget = new StringBuilder();
            for (int i = 0; i < sticker.length; i++) {
                if (targetMap[i] > 0) {
                    for (int j = 0; j < Math.max(targetMap[i] - sticker[i], 0); i++) {
                        newTarget.append((char) ('a' + i));
                    }
                }
            }
            int cur = dfs(newTarget.toString(), stickers, memo);
            if (cur != -1) {
                minStick = Math.min(minStick, cur);
            }
        }
        int res = (minStick == Integer.MAX_VALUE) ? -1 : 1 + minStick;
        memo.put(target, res);
        return res;
    }
    public int minStickersDP(String[] words, String target) {
        int N = target.length();
        int[] dp = new int[1 << N];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = -1;
        }

        for (int state = 0; state < dp.length; state++) {
            if (dp[state] == -1) continue;
            for (String word : words) {
                int now = state;
                for (char ch : word.toCharArray()) {
                    for (int i = 0; i < N; i++) {
                        if (((now >> i) & 1) == 1) continue;
                        if(target.charAt(i) == ch) {
                            now |= 1 << i;
                            break;
                        }
                    }
                }
                if (dp[now] == -1 || dp[now] > dp[state] + 1) {
                    dp[now] = dp[state] + 1;
                }
            }
        }
        return dp[(1 << N) - 1];
    }
}
