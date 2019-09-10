public class minimumSizeSubarraySum_209  {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int left = 0, right = 0,
                sum = 0, len = nums.length, res = len + 1;
        while (right < len) {
            while(sum < s && right < len)
                sum += nums[right++];
            while (sum >= s) {
                res = Math.min(res, right - left);
                sum -= nums[left++];
            }
        }
        return res == len + 1 ? 0 : res;
    }
}
