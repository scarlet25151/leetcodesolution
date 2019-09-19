import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class perfixAndsurfixSearch745 {
    class WordFilter {
        private Map<String, List<Integer>> prefixMap = new HashMap<>();
        private Map<String, List<Integer>> suffixMap = new HashMap<>();

        public WordFilter(String[] words) {
            for (int weight = 0; weight < words.length; weight ++) {
                for (int i = 0; i <= 10 && i <= words[weight].length(); i++) {
                    String prefixStr = words[weight].substring(0, i);
                    if (!prefixMap.containsKey(prefixStr)) prefixMap.put(prefixStr, new ArrayList<>());
                    prefixMap.get(prefixStr).add(weight);
                }
                for (int i = 0; i <= 10 && i <= words[weight].length(); i++) {
                    String suffixStr = words[weight].substring(words[weight].length() - i);
                    if (!suffixMap.containsKey(suffixStr)) suffixMap.put(suffixStr, new ArrayList<>());
                    suffixMap.get(suffixStr).add(weight);
                }
            }
        }

        public int f(String prefix, String suffix) {
            if (!prefixMap.containsKey(prefix) || !suffixMap.containsKey(suffix))
                return -1;
            List<Integer> p = prefixMap.get(prefix);
            List<Integer> s = suffixMap.get(suffix);
            int i = p.size() - 1, j = s.size() - 1;
            while (i >= 0 && j >= 0) {
                if (p.get(i) < s.get(j)) j--;
                else if (p.get(i) > s.get(j)) i--;
                else return p.get(i);
            }
            return -1;
        }
    }
}
