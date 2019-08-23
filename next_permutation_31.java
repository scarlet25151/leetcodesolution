import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;

public class next_permutation_31 {

    public void nextPermutation(int[] nums) {
        int n = nums.length, i = n - 2, j = n - 1;
        while (i >= 0 && nums[i] >= nums[i + 1]) --i;
        if (i >= 0) {
            while (nums[j] <= nums[i]) --j;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        int tmps[] = Arrays.copyOfRange(nums, i + 1, n - 1);
        Collections.reverse(Arrays.asList(tmps));
        for(int k = i + 1; k < n; ++k) {
            nums[k] = tmps[k - i - 1];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt(), j = scanner.nextInt();

        System.out.println(i + " " + j);

    }
}
