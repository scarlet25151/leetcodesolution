import java.util.Arrays;

public class countOfRangeSum327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return mergeCount(sums, 0, sums.length, lower, upper);
    }
    private int mergeCount(long[] sums, int left, int right,
                           int lower, int upper) {
        if (right - left <= 1) return 0;
        int mid = (left + right) / 2;
        int cnt = mergeCount(sums, left, mid, lower, upper)
                + mergeCount(sums, mid + 1, right, lower, upper);
        long[] temp = new long[right - left];
        int t = mid;
        for (int i = left, j = mid, k = mid, r = 0; i < mid; i++, r++) {
            while (k < right && sums[k] - sums[i] < lower) k++;
            while (j < right && sums[j] - sums[i] < upper) j++;
            while (t < right && sums[t] < sums[i]) temp[r++] = sums[t++];
            temp[r] = sums[i];
            cnt += j - k;
        }
        for (int i = 0; i < t - left; i++) {
            sums[left + i] = temp[i];
        }
        return cnt;
    }
}
