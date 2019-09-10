import java.util.*;

public class concatenatedWords472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words.length <= 2) return res;
        Set<String> dict = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            dict.remove(word);
            int len = word.length();
            if (len == 0) continue;
            boolean[] isMatched = new boolean[len + 1];
            isMatched[0] = true;
            for (int i = 0; i < len + 1; ++i) {
                for (int j = 0 ; j < i; ++j) {
                    if (isMatched[j] && dict.contains(word.substring(j, i))) {
                        isMatched[i] = true;
                        break;
                    }
                }
            }
            if (isMatched[len]) res.add(word);
            dict.add(word);
        }
        return res;
    }
}
