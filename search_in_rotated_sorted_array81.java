public class search_in_rotated_sorted_array81 {
    public boolean search(int[] nums, int target) {
        int n = nums.length, left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] >= target) left = mid + 1;
                else right = mid - 1;
            } else if (nums[mid] > nums[right]) {
                if (nums[mid] <= target && nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            } else --right;
        }
        return false;
    }
}
