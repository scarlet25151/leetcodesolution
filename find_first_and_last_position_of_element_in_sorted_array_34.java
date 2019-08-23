public class find_first_and_last_position_of_element_in_sorted_array_34 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length, left = 0, right = n - 1;
        if (left == right) {
            if (nums[left] == target) {
                int[] res = {0, 0};
                return res;
            } else {
                int[] res = {-1, -1};
                return res;
            }
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                int start = mid - 1, end = mid + 1;
                while (nums[start] == target && start >=0) start--;
                while (nums[end] == target && end < n) end++;
                int[] res = {start, end};
                return res;
            }
            if (nums[left] <= target && nums[mid] >target) right = mid - 1;
            else left = mid + 1;
        }
        int[] res = {-1, -1};
        return res;
    }
}
