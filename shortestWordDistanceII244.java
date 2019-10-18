import java.util.ArrayList;
import java.util.HashMap;

public class shortestWordDistanceII244 {
    class WordDistance {
        HashMap<String, ArrayList<Integer>> locations;

        public WordDistance(String[] words) {
            this.locations = new HashMap<>();

            for (int i = 0; i < words.length; i++) {
                if (!locations.containsKey(words[i])) {
                    locations.put(words[i], new ArrayList<>());
                    locations.get(words[i]).add(i);
                }
            }
        }

        public int shortest(String word1, String word2) {
            ArrayList<Integer> loc1, loc2;
            loc1 = locations.get(word1);
            loc2 = locations.get(word2);

            int l1 = 0, l2 = 0, minDiff = Integer.MAX_VALUE;
            while (l1 < loc1.size() && l2 < loc2.size()) {
                minDiff = Math.min(minDiff, Math.abs(loc1.get(l1) - loc2.get(l2)));
                if (loc1.get(l1) < loc2.get(l2)) {
                    l1++;
                } else {
                    l2++;
                }
            }
            return minDiff;
        }
    }
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            int t = p1;
            if (words[i].equals(word1)) p1 = i;
            if (words[i].equals(word2)) p2 = i;
            if (p1 != -1 && p2 != -1) {
                if (word1.equals(word2) && t != -1 && t != p1) {
                    res = Math.min(res, Math.abs(t - p1));
                } else if (p1 != p2) {
                    res = Math.min(res, Math.abs(p1 - p2));
                }
            }
        }
        return res;
    }
}
