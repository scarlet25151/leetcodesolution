import java.util.Arrays;

public class merge_sorted_array_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int[] num1_tmp = Arrays.copyOfRange(nums1, 0, m);
        for(int i = 0, j = 0, k = 0; k <m + n; k++) {
            if (i >= num1_tmp.length) {
                res[k] = nums2[j++];
                continue;
            }
            if (j >= nums2.length) {
                res[k] = num1_tmp[i++];
                continue;
            }
            if (num1_tmp[i] > nums2[j]) {
                res[k] = nums2[j++];
            } else
                res[k] = num1_tmp[i++];
        }

        for (int k = 0; k < m + n; ++k) {
            nums1[k] = res[k];
        }
    }

}
