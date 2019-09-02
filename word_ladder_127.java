
import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class word_ladder_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        Map<String, ArrayList<String>> allComboDicct = new HashMap<>();
        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        ArrayList<String> transformations =
                                allComboDicct.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(word);
                        allComboDicct.put(word, transformations);
                    }
                });
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));

        HashMap<String, Boolean> isVisited = new HashMap<>();
        isVisited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < L; ++i) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                for (String adjacentWord : allComboDicct.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjacentWord.equals(endWord))
                        return level + 1;
                    if (!isVisited.containsKey(adjacentWord)) {
                        isVisited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}
