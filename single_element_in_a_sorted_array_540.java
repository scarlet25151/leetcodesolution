import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class single_element_in_a_sorted_array_540 {
    public int singleNonDuplicate(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();
        for (int num : nums) {
            if (integerSet.contains(num))
                integerSet.remove(num);
            else
                integerSet.add(num);
        }
        Iterator<Integer> it = integerSet.iterator();
        return it.next();
    }
}
