import java.util.*;

public class group_anagrams_49 {
    //maintain a map ans :{String -> list}
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List> res = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!res.containsKey(key)) res.put(key, new ArrayList());
            res.get(key).add(s);
        }
        return new ArrayList(res.values());
    }
    public List<List<String>> groupAnagrams_sol2(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List> res = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; ++i) {
                sb.append('#');
                sb.append(count[i]);
            }
        }
        return new ArrayList<>();
    }
}
