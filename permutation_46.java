import java.util.*;

public class permutation_46 {
    public void backtrack(int n,
                          List<Integer> nums,
                          List<List<Integer>> out,
                          int first) {
        if (first == n)
            out.add(nums);
        for (int i = first; i < n; ++i) {
            Collections.swap(nums, first, i);
            backtrack(n, nums, out, first + 1);
            Collections.swap(nums, first, i);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        for(int num : nums)
            out.add(num);
        int n = nums.length;
        backtrack(n, out, res, 0);
        return res;
    }

}
