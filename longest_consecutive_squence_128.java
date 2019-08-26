import java.util.HashSet;
import java.util.Set;

public class longest_consecutive_squence_128 {
    public int longestConsecutive_solu1(int[] nums) {
        int res = 0;
        Set<Integer> s = new HashSet<>();
        for (int num : nums) s.add(num);
        for (int num : nums) {
            if (s.remove(num)) {
                int pre = num - 1, post = num + 1;
                while(s.remove(pre)) --pre;
                while(s.remove(post)) ++post;
                res = Math.max(res, post - pre - 1);
            }
        }
        return res;
    }

}
