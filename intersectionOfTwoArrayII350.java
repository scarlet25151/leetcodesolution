import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class intersectionOfTwoArrayII350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> resList = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (int num : nums2)
            if (map.get(num) != null && map.get(num) > 0) {
                map.replace(num, map.get(num) - 1);
                resList.add(num);
            }
        return resList.stream().mapToInt(i->i).toArray();
    }
}
