import java.util.HashMap;
import java.util.Map;

public class longes_substring_with_at_most_two_distinct_characters_159 {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int res = 0, left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while (map.size() > 2) {
                if (map.get(s.charAt(left)) == 0) map.remove(s.charAt(left));
                ++left;

            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
    public int lengthOfLongestSubstringTwoDistinct_solu2(String s) {
        int res = 0, left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                map.replace(s.charAt(i), i);
            }
            while (map.size() > 2) {
                if (map.get(s.charAt(left)) == left)
                    map.remove(s.charAt(left));
                ++left;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
    public static void main(String[] args) {
        String testSample = "ccaabbb";
        System.out.println(lengthOfLongestSubstringTwoDistinct(testSample));

    }
}
