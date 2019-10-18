import java.util.ArrayList;
import java.util.List;

public class missingRanges163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int l = lower;
        for (int i = 0; i <= nums.length; i++) {
            int r = (i < nums.length && nums[i] <= upper) ? nums[i] : upper + 1;
            if (l == r) ++l;
            else if (r > l) {
                res.add(r - 1 == 1 ? String.valueOf(l) : String.valueOf(l) + "->" + String.valueOf(r - 1));
                l = r + 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {

        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0, upper = 99;

        missingRanges163 solution = new missingRanges163();
        List<String> res = solution.findMissingRanges(nums, lower, upper);
    }
}
