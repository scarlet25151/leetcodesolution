package biweeklyContest8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class conutSubstringswithOnlyOneDistinctLetter5067 {
    private static boolean isOneDistinct(String s) {
        Set<Character> charSet = new HashSet<>();
        for (char ch : s.toCharArray()) {
            charSet.add(ch);
            if (charSet.size() > 1) {
                return false;
            }
        }
        return true;
    }
    public static int countLetters(String S) {
        int strLen = S.length();
        HashMap<String, Integer> subStrFrequency = new HashMap<>();
        for (int subStrLen = 1; subStrLen <= strLen; ++subStrLen) {
            for (int i = 0; i < strLen - subStrLen + 1; ++i) {
                String subStr = S.substring(i, i + subStrLen);
                if (isOneDistinct(subStr)) {
                    subStrFrequency.put(subStr,
                            subStrFrequency.getOrDefault(subStr, 0) + 1);
                }
            }
        }
        int res = 0;
        for (int frequency : subStrFrequency.values()) {
            res += frequency;
        }
        return res;
    }
    int countkDist(String str, int k)
    {
        int res = 0;
        int n = str.length();
        int cnt[] = new int[26];
        for (int i = 0; i < n; i++)
        {
            int dist_count = 0;
            Arrays.fill(cnt, 0);
            for (int j=i; j<n; j++)
            {
                if (cnt[str.charAt(j) - 'a'] == 0)
                    dist_count++;

                cnt[str.charAt(j) - 'a']++;

                if (dist_count == 1)
                    res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aaaba";
        int res = countLetters(s);
    }
}
