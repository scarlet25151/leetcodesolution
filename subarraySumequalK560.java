import java.util.HashMap;
import java.util.Map;

public class subarraySumequalK560 {
    public int subarraySum(int[] nums, int k) {
        int res = 0, sum = 0, n = nums.length;
        Map<Integer, Integer> numMap = new HashMap<>();
        numMap.put(0, 1);
        for (int num : nums) {
            sum += num;
            res += numMap.getOrDefault(sum - k, 0);
            numMap.put(sum, numMap.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
