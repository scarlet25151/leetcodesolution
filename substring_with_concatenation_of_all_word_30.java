import java.util.*;

public class substring_with_concatenation_of_all_word_30 {
    //brute force
    public List<Integer> findSubstring(String s, String[] words) {
        final Map<String, Integer> wordCnt = new HashMap<>();

        for (final String word : words) {
            wordCnt.put(word, wordCnt.getOrDefault(word, 0) + 1);
        }

        final List<Integer> indexes = new ArrayList<>();
        final int n = s.length(), num = words.length, len = words[0].length();

        for (int i = 0; i < n - num * len + 1; i++) {
            final Map<String, Integer> strCnt = new HashMap<>();
            int j = 0;
            while (j < num) {
                final String word = s.substring(i + j * len, i + (j + 1) * len);
                if (wordCnt.containsKey(word)) {
                    strCnt.put(word, strCnt.getOrDefault(word, 0) + 1);
                    if (strCnt.get(word) > wordCnt.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}
