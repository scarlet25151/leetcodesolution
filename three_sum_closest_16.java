import java.util.*;

public class three_sum_closest_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minGap = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i ++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int Gap = Math.abs(sum - target);
                if (Gap == 0)
                    return sum;
                else if (Gap < minGap) {
                    minGap = Gap;
                    res = sum;
                }

                if (sum <= target)
                    left++;
                else if (sum > target)
                    right--;
            }
        }
        return res;

    }
    public static void main (String[] args) {

    }
}
