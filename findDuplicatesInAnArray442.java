import java.util.ArrayList;
import java.util.List;

public class findDuplicatesInAnArray442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int j = Math.abs(nums[i]) - 1;
            if (nums[j] < 0)
                res.add(j + 1);
            else
                nums[j] = -nums[j];
        }
        return res;
    }
}
