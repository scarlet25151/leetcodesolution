public class findMinimumInRotatedSortedArray153 {

    public int findMin(int[] nums) {
        return backtracking(nums, 0, nums.length - 1);
    }
    private int backtracking(int[] nums, int start, int end) {
        if (nums[start] <= nums[end]) return nums[start];
        int mid = (start + end) / 2;
        return Math.min(backtracking(nums, start, mid), backtracking(nums, mid, end));
    }
    private int backtrackingDuplicate(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        if (nums[start] < nums[end]) return nums[start];
        int mid = (start + end) / 2;
        return Math.min(backtracking(nums, start, mid), backtracking(nums, mid + 1, end));
    }
}
