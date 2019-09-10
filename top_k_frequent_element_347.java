import javafx.util.Pair;

import java.util.*;

public class top_k_frequent_element_347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> elementCnt = new HashMap<>();
        for (int num : nums) {
            elementCnt.put(num, elementCnt.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>(
                (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        for (int element : elementCnt.keySet()) {
            heap.offer(new Pair(element, elementCnt.get(element)));
            if (heap.size() > k) heap.poll();
        }
        List<Integer> res = new ArrayList<>();
        while (!heap.isEmpty()) res.add(heap.poll().getKey());
        Collections.reverse(res);
        return res;
    }
    public List<Integer> topKFrequent_bucket(int[] nums, int k) {
        Map<Integer, Integer> elementCnt = new HashMap<>();
        for (int num : nums) {
            elementCnt.put(num, elementCnt.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : elementCnt.keySet()) {
            int frequency = elementCnt.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; --i) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - topK.size()))
                topK.addAll(buckets[i]);
            else
                topK.addAll(buckets[i].subList(0, k - topK.size()));
        }
        return topK;
    }

}
