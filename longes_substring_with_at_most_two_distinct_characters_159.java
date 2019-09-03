import java.util.HashMap;
import java.util.Map;

public class longes_substring_with_at_most_two_distinct_characters_159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int res = 0, left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while (map.size() > 2) {
                if (map.get(s.charAt(left)) == 1) map.remove(s.charAt(left));
                ++left;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
