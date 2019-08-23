public class search_in_rotated_sorted_array_33 {
    int nums[];
    int target;
    public int find_rotate_index(int start, int end) {
        if (nums[start] < nums[end]) return 0;
        while (start <= end) {
            int pivot = (start + end) / 2;
            if (nums[pivot] > nums[pivot + 1])
                return pivot + 1;
            else {
                if (nums[pivot] < nums[start]) {
                    end = pivot - 1;
                } else {
                    start = pivot + 1;
                }
            }
        }
        return 0;
    }
    public int b_search(int left, int right) {
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target) return pivot;
            else {
                if (target < nums[pivot])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        this.nums = nums; this.target = target;
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return this.nums[0] == target ? 0 : -1;

        int rotate_index = find_rotate_index(0, n - 1);
        if (nums[rotate_index] == target)
            return rotate_index;
        if (rotate_index == 0)
            return b_search(rotate_index, n - 1);
        if (target < nums[0])
            return b_search(rotate_index, n - 1);
        return b_search(0, rotate_index);
    }
}
