import java.util.*;
public class Minimum_window_substring_76 {
    public String minWindow_solution1(String s, String t) {
        //To create a array to store most common character
//        int[] charCnt = new int[256];
        int[] charCnt = new int[128];
        Arrays.fill(charCnt, 0);
        int start = 0, cnt = 0, minStart = -1, minLen = Integer.MAX_VALUE;
        char[] tc = t.toCharArray();
        for (char c : tc) ++charCnt[c];
        for (int i = 0; i < s.length(); ++i) {
            if (--charCnt[s.charAt(i)] >= 0) ++cnt;
            while (cnt == t.length()) {
                if (minLen > i - start + 1) {
                    minLen = i - start + 1;
                    minStart = start;
                }
                if (++charCnt[s.charAt(start)] > 0) --cnt;
                ++start;
            }
        }
        return minStart == -1 ? "" : s.substring(minStart, minStart + minLen - 1);
    }
}
  