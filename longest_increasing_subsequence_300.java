import java.util.Arrays;

public class longest_increasing_subsequence_300 {
    public int lengthOfLIS(int[] nums) {
        int res = 0, n = nums.length;
        int[] dp = new int[n];
        for(int num : nums) {
            int idx = Arrays.binarySearch(dp, 0, res, num);
            if (idx < 0) idx = -(idx + 1);
            dp[idx] = num;
            if (idx == res) {
                res++;
            }
        }
        return res;
    }
}
