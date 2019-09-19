import java.util.HashMap;
import java.util.Map;

public class continuousSubarraySum523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length, sum = 0;
        Map<Integer, Integer> numPathMap = new HashMap<>();
        numPathMap.put(0, -1);
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            int t = (k == 0) ? sum : (sum % k);
            if (numPathMap.containsKey(t)) {
                if (i - numPathMap.get(t) > 1) return true;
            } else numPathMap.put(t, i);
        }
        return false;
    }
}
