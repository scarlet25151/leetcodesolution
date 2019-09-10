package biweeklyContest8;

import java.util.*;

public class shortestDistanceToTargetColor_5070 {
    public static List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        HashMap<Integer, List<Integer>> colorPosition = new HashMap<>();
        for (int idx = 0; idx < colors.length; ++idx) {
            if (!colorPosition.containsKey(colors[idx])) {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(idx);
                colorPosition.put(colors[idx], indexes);
            } else {
                List<Integer> indexes = colorPosition.get(colors[idx]);
                indexes.add(idx);
                colorPosition.replace(colors[idx], indexes);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int[] query : queries) {
            if (!colorPosition.containsKey(query[1])) {
                res.add(-1);
                continue;
            }
            List<Integer> colorPos = colorPosition.get(query[1]);
            int idx = Arrays.binarySearch(colorPos.toArray(), query[0]);
            idx = idx == -1 ? 0 : idx;
            idx = idx < 0 ? - idx : idx;
            idx = idx >= colorPos.size() ? colorPos.size() - 1 : idx;
            int minDist = idx > 0 ?
                    Math.min(Math.abs(colorPos.get(idx) - query[0]), Math.abs(colorPos.get(idx - 1) - query[0])) :
                    Math.abs(colorPos.get(idx) - query[0]);
            minDist = idx < colorPos.size() - 1 ?
                    Math.min(minDist, Math.abs(colorPos.get(idx + 1) - query[0])) : minDist;
            res.add(minDist);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] colors = {3,1,1,2,3,3,2,1,2,3,1,1,3,2,3,1,1,1,1,2,2,1,2,2,2,1,1,1,1,2,3,3,3,1,3,2,1,1,2,2,1,3,1,2,1,1,2,2,1,2};
        int[][] queries = {{10, 2}};
        List<Integer> res = shortestDistanceColor(colors, queries);
    }
}
