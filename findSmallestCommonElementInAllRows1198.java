import java.util.*;

public class findSmallestCommonElementInAllRows1198 {
    public int smallestCommonElement(int[][] mat) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                map.put(mat[i][j], map.getOrDefault(mat[i][j], 0) + 1);
            }
        }
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == mat.length) {
                res = Math.min(res, entry.getKey());
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
