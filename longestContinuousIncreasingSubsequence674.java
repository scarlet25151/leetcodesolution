public class longestContinuousIncreasingSubsequence674 {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = 1;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] > nums[i - 1] ? dp[i - 1] + 1 : 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
