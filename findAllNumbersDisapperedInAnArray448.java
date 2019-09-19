import java.util.ArrayList;
import java.util.List;

public class findAllNumbersDisapperedInAnArray448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = Math.abs(nums[i]) - 1;
            nums[j] = nums[j] > 0 ? -nums[j] : nums[j];
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                res.add(i);
        }
        return res;
    }
}
