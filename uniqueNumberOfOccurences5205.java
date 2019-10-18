import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class uniqueNumberOfOccurences5205 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        HashSet<Integer> compare = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (compare.contains(entry.getValue())) {
                return false;
            } else {
                compare.add(entry.getValue());
            }
        }
        return true;
    }
}
