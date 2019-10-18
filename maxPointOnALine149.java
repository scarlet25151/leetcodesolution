import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class maxPointOnALine149 {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public int maxPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
            int duplicate = 1;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    duplicate++;
                    continue;
                }
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int d = gcd(dx, dy);
                Pair p = new Pair(dx / d, dy / d);
                map.put(p, map.getOrDefault(p, 0) + 1);
            }
            res = Math.max(res, duplicate);

            for (Map.Entry<Pair<Integer, Integer>, Integer> entry : map.entrySet()) {
                res = Math.max(res, entry.getValue() + duplicate);
            }
        }
        return res;
    }
}
