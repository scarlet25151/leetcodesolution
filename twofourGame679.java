import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class twofourGame679 {
    public boolean judgePoint24(int[] nums) {
        boolean res = false;
        double tol = 0.001;
        List<Double> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add((double) num);
        }
        dfs(arr, tol, res);
        return res;
    }

    private boolean dfs(List<Double> nums, double tol, boolean res) {
        if (res) return true;
        if (nums.size() == 1) {
            if (Math.abs(nums.get(0) - 24) < tol)
                res = true;
            return res;
        }
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < i; ++j) {
                double p = nums.get(i), q = nums.get(j);
                List<Double> tmp = new ArrayList<>(Arrays.asList(p + q, p - q, q - p, p * q));
                if (p > tol) tmp.add(q / p);
                if (q > tol) tmp.add(p / q);
                nums.remove(i);
                nums.remove(j);
                for (double digit : tmp) {
                    nums.add(digit);
                    dfs(nums, tol, res);
                    nums.remove(digit);
                }
                nums.add(j, q);
                nums.add(i, p);
            }
        }
        return false;
    }
}
