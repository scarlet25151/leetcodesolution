import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sentence_similarityII_737 {

    public boolean areSentencesSimilarTwo(
            String[] words1, String[] words2, List<List<String>> pairs) {
        Map<String, Integer> dict = new HashMap<>();
        if (words1.length != words2.length) return false;

        int[] root = new int[2 * pairs.size()];
        for (int i = 0; i < root.length; ++i) {
            root[i] = i;
        }

        int index = 0;

        for (List<String> pair : pairs) {
            for (String p : pair) {
                if (!dict.containsKey(p)) {
                    dict.put(p, index++);
                }
            }
            root[dict.get(pair.get(0))] = find(root, dict.get(pair.get(1)));
        }
        for (int i = 0; i < words1.length; ++i) {
            String word1 = words1[i], word2 = words2[i];
            if (word1.equals(word2)) continue;
            if (!dict.containsKey(word1) || !dict.containsKey(word2) ||
                    root[dict.get(word1)] != root[dict.get(word2)])
                return false;
        }
        return true;
    }
    private int find(int[] root, int i) {
        if (root[i] == i) return i;
        return find(root, root[i]);
    }

}
