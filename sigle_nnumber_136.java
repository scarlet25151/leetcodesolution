import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class sigle_nnumber_136 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int num : nums) {
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
        }
        for (int k : hashmap.keySet()) {
            if (hashmap.get(k) == 1) return k;
        }
        return -1;
    }
}
