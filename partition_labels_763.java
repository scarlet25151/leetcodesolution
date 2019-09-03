import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class partition_labels_763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int n = S.length(), start = 0, last = 0;
        Map<Character, Integer> positionDict = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            if (!positionDict.containsKey(S.charAt(i))) {
                positionDict.put(S.charAt(i), i);
            } else {
                positionDict.replace(S.charAt(i), i);
            }
        }
        for (int i = 0; i < n; ++i) {
            last = Math.max(last, positionDict.get(S.charAt(i)));
            if (i == last) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
