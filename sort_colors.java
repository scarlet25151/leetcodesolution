public class sort_colors {
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, cur = 0;
        while (cur < right) {
            if (nums[cur] == 0) {
                swap(nums, left, cur);
                left++;
            } else if (nums[cur] == 2) {
                swap(nums, right, cur);
                right--;
            }
            cur++;
        }
    }
}
