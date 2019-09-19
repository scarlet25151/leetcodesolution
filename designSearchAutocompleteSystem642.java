import javafx.util.Pair;

import java.util.*;

public class designSearchAutocompleteSystem642 {
    public static class AutocompleteSystem {
        private static Map<String, Integer> wordFrequency = new HashMap<>();
        private static String data;
        public AutocompleteSystem(String[] sentences, int[] times) {
            for (int i = 0; i < sentences.length; ++i)
                wordFrequency.put(sentences[i],
                        wordFrequency.getOrDefault(sentences[i], 0) + times[i]);
            data = "";
        }

        public static List<String> input(char c) {
            if (c == '#') {
                wordFrequency.put(data, wordFrequency.getOrDefault(data, 0) + 1);
                data = "";
                return new ArrayList<>();
            }
            data += c;
            Queue<Pair<String, Integer>> queue = new PriorityQueue<>(new Comparator<Pair<String, Integer>>() {
                @Override
                public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
                    return o2.getValue().equals(o1.getValue()) ?
                            o2.getKey().compareTo(o1.getKey()) : o2.getValue() - o1.getValue();
                }
            });
            for (String word : wordFrequency.keySet()) {
                boolean matched = true;
                for (int i = 0; i < data.length(); ++i) {
                    if (data.length() != word.length() || data.charAt(i) != word.charAt(i)) {
                        matched = false;
                        break;
                    }
                }
                if (matched) {
                    queue.offer(new Pair(word, wordFrequency.get(word)));
                    if (queue.size() > 3) queue.poll();
                }
            }
            List<String> res = new ArrayList<>();
            while (!queue.isEmpty()) {
                res.add(queue.poll().getKey());
            }
            Collections.reverse(res);
            return res;

        }
    }
    public static void main(String[] args) {
        String[] sentences = {"abc", "abbc", "a"};
        int[] times = {3, 3, 3};
        AutocompleteSystem n = new AutocompleteSystem(sentences, times);
        List<String> list = AutocompleteSystem.input('b');
        list = AutocompleteSystem.input('c');
        list = AutocompleteSystem.input('#');
        list = AutocompleteSystem.input('b');
        list = AutocompleteSystem.input('c');
        list = AutocompleteSystem.input('#');
        list = AutocompleteSystem.input('a');
        list = AutocompleteSystem.input('b');
//        list = AutocompleteSystem.input('c');
//        list = AutocompleteSystem.input('#');
//        list = AutocompleteSystem.input('a');
//        list = AutocompleteSystem.input('b');
//        list = AutocompleteSystem.input('c');
//        list = AutocompleteSystem.input('#');


    }
}
