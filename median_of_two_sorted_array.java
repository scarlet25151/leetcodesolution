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
