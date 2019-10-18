public class reversePairs493 {
    public int reversePairs(int[] nums) {
        return mergeCount(nums, 0, nums.length - 1);
    }
    private void merge(int[] nums, int left, int mid, int right) {
        int n1 = (mid - left + 1);
        int n2 = (right - mid);
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = nums[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = nums[mid + 1 + j];
        }
        for (int i = 0, j = 0, k = left; k <= right; k++) {
            if (j >= n2 || (i < n1 && L[i] <= R[j]))
                nums[k] = L[i++];
            else
                nums[k] = R[j++];
        }
    }
    private int mergeCount(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) / 2;
        int count = mergeCount(nums, left, mid) + mergeCount(nums, mid + 1, right);
        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && (long) nums[i] > (long) (nums[j] * 2)) j++;
            count += j - (mid + 1);
        }
        merge(nums, left, mid, right);
        return count;
    }
}
