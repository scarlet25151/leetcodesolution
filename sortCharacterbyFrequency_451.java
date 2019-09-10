import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sortCharacterbyFrequency_451 {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyCnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyCnt.put(c, frequencyCnt.getOrDefault(c, 0) + 1);
        }
        List<Character>[] bucket = new ArrayList[s.length() + 1];
        for (char c : frequencyCnt.keySet()) {
            int frequency = frequencyCnt.get(c);
            if (bucket[frequency] == null)
                bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] == null) {
                continue;
            }
            for (char c : bucket[i]) {
                for (int j = 0; j < i; j++) {
                    stringBuilder.append(c);
                }
            }
        }
        return stringBuilder.toString();
    }
}
