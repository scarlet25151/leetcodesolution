import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class subsetII_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        int size = 1, last = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            if (last != nums[i]) {
                last = nums[i];
                size = res.size();
            }
            int newSize = res.size();
            for (int j = newSize - size; j < newSize; ++j) {
                res.get(j).add(last);
                List<Integer> resBack = res.get(res.size() - 1);
                resBack.add(nums[i]);
                res.add(resBack);
            }
        }
        return res;
    }
    public List<List<Integer>> subsetsWithDupSolution2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        Stack<Integer> out = new Stack<>();
        Arrays.sort(nums);
        getSubsets(nums, 0, out, res);
        return res;
    }
    private void getSubsets(int[] nums, int pos,
                            Stack<Integer> out, List<List<Integer>> res) {
        res.add(new ArrayList<>(out));
        for (int i = pos; i < nums.length; ++i) {
            out.push(nums[i]);
            getSubsets(nums, i + 1, out, res);
            out.pop();
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) ++i;
        }
    }
}
