public class sliding_window_maximum_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // special situation.
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        // initial the variables
        int[] left = new int[n], right = new int[n];
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; ++i) {
            if (i % k == 0) left[i] = nums[i];// block_start;
            else left[i] = Math.max(left[i - 1], nums[i]);
            int j = n - i - 1;
            if ((j + 1) % k == 0) right[j] = nums[j]; // block_end
            else right[j] = Math.max(right[j + 1], nums[j]);
        }
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int j = i + k - 1;
            res[i] = Math.max(left[j], right[i]);
        }
        return res;
    }
}
