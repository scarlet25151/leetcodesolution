import java.util.HashMap;
import java.util.Map;

public class splitArrayIntoConsecutiveSubsequences659 {
    public boolean isPossible(int[] nums) {
        Counter count = new Counter();
        Counter tails = new Counter();

        for (int num : nums) count.add(num, 1);

        for (int num : nums) {
            if (count.get(num) == 0) {
                continue;
            }
            if (tails.get(num) > 0) {
                tails.add(num, -1);
                tails.add(num + 1, 1);
            } else if (count.get(num + 1) > 0 && count.get(num + 2) > 0) {
                count.add(num + 1, -1);
                count.add(num + 2, -1);
                count.add(num + 3, 1);
            } else return false;
            count.add(num, - 1);
        }
        return true;
    }
    class Counter extends HashMap<Integer, Integer> {
        public int get(int k) {
            return containsKey(k) ? super.get(k) : 0;
        }

        public void add(int k, int v) {
            put(k, get(k) + v);
        }
    }
}
