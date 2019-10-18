import java.util.*;

public class smallestStringWithSwaps1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] find = new int[s.length()];
        Map<Integer, List<Integer>> rootInt = new HashMap<>();
        for (int i = 0; i < find.length; i++) {
            find[i] = i;
        }
        for (List<Integer> pair : pairs) {
            int rootA = findRoot(find, pair.get(0));
            int rootB = findRoot(find, pair.get(1));
            if (rootA != rootB)
                find[rootB] = rootA;
        }

        for (int i = 0; i < find.length; i++) {
            int root = findRoot(find, i);
            if (!rootInt.containsKey(root)) rootInt.put(root, new ArrayList<>());
            rootInt.get(root).add(i);
        }
        char[] ss = s.toCharArray();
        for (Map.Entry<Integer, List<Integer>> entry : rootInt.entrySet()) {
            List<Integer> rootIdx = rootInt.get(entry.getKey());
            List<Character> sortChar = new ArrayList<>();
            for (int idx : rootIdx)
                sortChar.add(s.charAt(idx));
            Collections.sort(sortChar);
            for (int i = 0; i < rootIdx.size(); i++)
                ss[rootIdx.get(i)] = sortChar.get(i);
        }
        return new String(ss);
    }
    private int findRoot(int[] root, int i) {
        if (root[i] != i)
            i = findRoot(root, root[i]);
        return i;
    }
}
