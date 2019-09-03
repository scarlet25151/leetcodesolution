public class maximum_product_subarray_152 {
    public int maxProduct(int[] nums) {
            int res = nums[0], n = nums.length;
            int[] dp_max = new int[n], dp_min = new int[n];
            dp_max[0] = nums[0];
            dp_min[0] = nums[0];

            for (int i = 1; i < n; i++) {
                dp_max[i] = Math.max(nums[i],
                        Math.max(dp_max[i - 1] * nums[i], dp_min[i - 1] * nums[i]));
                dp_min[i] = Math.min(nums[i],
                        Math.min(dp_max[i - 1] * nums[i], dp_min[i - 1] * nums[i]));
                res = Math.max(dp_max[i], res);
            }
            return res;
    }
}
