import java.util.*;

public class four_sum_17 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] < target)
                        left++;
                    else if (nums[i] + nums[j] + nums[left] + nums[right] > target)
                        right--;
                    else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++; right--;
                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                        while (left < right &&nums[right] == nums[right] + 1)
                            right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
