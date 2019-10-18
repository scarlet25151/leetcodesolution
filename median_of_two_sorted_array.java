import sun.nio.cs.ext.MacArabic;

import java.util.*;

public class median_of_two_sorted_array {
    public static float merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= nums1.length)
                result[index] = nums2[j++];
            else if (j >= nums2.length)
                result[index] = nums1[i++];
            else if (nums1[i] > nums2[j])
                result[index] = nums2[j++];
            else
                result[index] = nums1[i++];
        }
        float median;
        if (result.length % 2 == 0)
            median = (float) (result[result.length / 2] + result[result.length / 2 - 1]) / 2;
        else
            median = (float) result[Math.floorDiv(result.length, 2)];

        return median;
    }
    public double findMedianSortedArrays_binarySearch(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // make sure m <= n
        if (n < m) {
            int[] tmp1 = nums1; nums1 = nums2; nums2 = tmp1;
            int tmp2 = m; m = n; n = tmp2;
        }
        int iLeft = 0, iRight = m, halfLen = (m + n + 1) / 2;
        while (iLeft <= iRight) {
            int i = (iLeft + iRight) / 2;
            int j = halfLen - i;
            if (i < iRight && nums2[j - 1] > nums1[i]) {
                iLeft = i + 1;
            }
            else if (i > iLeft && nums1[i - 1] > nums2[j]) {
                iRight = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) { maxLeft = nums2[j - 1];}
                else if (j == 0) { maxLeft = nums1[i - 1]; }
                else { maxLeft = Math.max(nums1[i - 1], nums2[j - 1]); }
                if ((m + n) % 2 == 1) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = nums2[j]; }
                else if (j == n) { minRight = nums1[i]; }
                else { minRight = Math.min(nums1[i], nums2[j]); }
                return (maxLeft + minRight) / 2.;
            }
        }
        return 0.;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a_len, b_len;
        a_len = scanner.nextInt();
        b_len = scanner.nextInt();
        int[] a = new int[a_len], b = new int[b_len];

        for (int i = 0; i < a_len; i++)
            a[i] = scanner.nextInt();
        for (int j = 0; j < b_len; j++)
            b[j] = scanner.nextInt();

        System.out.println(merge(a, b));
    }
}
