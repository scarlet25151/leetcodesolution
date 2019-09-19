import java.util.HashMap;
import java.util.Map;

public class frogJump403 {
    public boolean canCross(int[] stones) {
        Map<Integer, Boolean> map = new HashMap<>();
        return dfs(stones, 0, 0, map);
    }
    private boolean dfs(int[] stones, int pos, int jump, Map<Integer, Boolean> map) {
        int n = stones.length, key = pos | jump << 12;
        if (pos >= n - 1) return true;
        if (map.containsKey(key)) return map.get(key);
        for (int i = pos + 1; i < n; i++) {
            int dist = stones[i] - stones[pos];
            if (dist < jump - 1) continue;
            if (dist > jump + 1) {
                map.put(key, false);
                return false;
            }
            if (dfs(stones, i, dist, map)) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }
}
