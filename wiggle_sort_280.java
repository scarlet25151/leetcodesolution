public class wiggle_sort_280 {
    public void wiggleSort(int[] nums) {
        boolean needReverse = true;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (needReverse) {
                if (nums[i] > nums[i + 1])
                    swap(nums, i, i + 1);
            } else {
                if (nums[i] < nums[i + 1])
                    swap(nums, i, i + 1);
            }
            needReverse = !needReverse;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
