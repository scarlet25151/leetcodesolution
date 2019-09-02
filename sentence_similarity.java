import java.util.*;

public class sentence_similarity {
    public boolean areSentencesSimilar(String[] words1, String[] words2,
                                       List<List<String>> pairs) {
        if (words1.length != words2.length) return false;
        HashMap<String, List<String>> dict = new HashMap<>();
        for (List<String> pair : pairs) {
            if (dict.containsKey(pair.get(0))) {
                dict.get(pair.get(0)).add(pair.get(1));
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(pair.get(1));
                dict.put(pair.get(0), tmp);
            }
        }
        
        for (int i = 0; i < words1.length; ++i) {
            if (words1[i].equals(words2[i])) continue;
            if (!dict.get(words1[i]).contains(words2[i]) && !dict.get(words2[i]).contains(words1[i])) return false;
        }
        return true;
    }
    public boolean areSentencesSimilar_sol2(
            String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;

        Set<String> pairset = new HashSet();
        for (List<String> pair: pairs)
            pairset.add(pair.get(0) + "#" + pair.get(1));

        for (int i = 0; i < words1.length; ++i) {
            if (!words1[i].equals(words2[i]) &&
                    !pairset.contains(words1[i] + "#" + words2[i]) &&
                    !pairset.contains(words2[i] + "#" + words1[i]))
                return false;
        }
        return true;
    }
}
