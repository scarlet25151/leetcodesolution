import java.util.ArrayList;
import java.util.Arrays;

public class getEqualSubstringsWithinBudget5207 {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        int n = ss.length;
        int[] cost = new int[n];
        int res = 0, totalCost = 0;
        for (int i = 0; i < n; i++) {
            cost[i] = Math.abs(ss[i] - ts[i]);
        }
        int left = 0, right = 0;
        int maxLen = 0, sumCost = 0;
        while (left <= right && right < n) {
            if (sumCost > maxCost) {
                sumCost -= cost[left];
                left++;
                maxLen = Math.max(maxLen, right - left + 1);
            } else {
                sumCost += cost[right];
                right++;
                maxLen = Math.max(maxLen, right - left - 1);
            }

        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "krpgjbjjznpzdfy";
        String t = "nxargkbydxmsgby";

        int maxCost = 14;
        getEqualSubstringsWithinBudget5207 obj = new getEqualSubstringsWithinBudget5207();
        int out = obj.equalSubstring(s, t, maxCost);

    }
}
