import javafx.util.Pair;

import java.util.*;

public class top_k_frequent_words_692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word :words) {
            if (map.containsKey(word))
                map.replace(word, map.get(word) + 1);
            else
                map.replace(word, 1);
        }
        Queue<Pair<String, Integer>> queue = new PriorityQueue<>(map.size(), new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (String word : map.keySet()) {
            queue.add(new Pair<>(word, map.get(word)));
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            res.add(queue.poll().getKey());
        }
        return res;
    }
    public List<String> topKFrequent_sol2(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w2.compareTo(w1) : count.get(w1) - count.get(w2) );

        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }

}
