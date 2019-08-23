import java.util.*;

public class permutation_II_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res);
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> res) {
        if (start >= nums.length) {
            List<Integer> nums_list = new ArrayList<>();
            for (int num : nums) {
                nums_list.add(num);
            }
            res.add(nums_list);
        }
        for (int i = start; i < nums.length; ++i) {
            int j = i - 1;
            while (j >= start && nums[j] != nums[i]) --j;
            if (j != start - 1) continue;
            swap(nums, i, start);
            backtrack(nums, start + 1, res);
            swap(nums, i, start);
        }
    }
}
