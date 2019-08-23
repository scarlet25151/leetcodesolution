import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class subset_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> out = new Stack<>();
        Arrays.sort(nums);
        getSubsets(nums, 0, out, res);
        return res;
    }

    public void getSubsets(int[] nums, int pos, Stack<Integer> out,
                           List<List<Integer>> res) {
        List<Integer> outList = new ArrayList<>(out);
        res.add(outList);
        for (int i = pos; i < nums.length; ++i) {
            out.push(nums[i]);
            getSubsets(nums, i + 1, out, res);
            out.pop();
        }
    }
}
