import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class optimalAccountingBalancing465 {
    private int res = Integer.MAX_VALUE;

    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> relation = new HashMap<>();
        for (int[] trans : transactions) {
            relation.put(trans[0], relation.getOrDefault(trans[0], 0) - trans[2]);
            relation.put(trans[1], relation.getOrDefault(trans[1], 0) + trans[2]);
        }
        List<Integer> account = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : relation.entrySet()) {
            if (entry.getValue() != 0) account.add(entry.getValue());
        }
        dfs(account.stream().mapToInt(i->i).toArray(), 0, 0);
        return res;
    }

    private void dfs(int[] account, int start, int cnt) {
        int n = account.length;
        while (start < n && account[start] == 0) start++;
        if (start == n) {
            res = Math.min(res, cnt);
            return;
        }
        for (int i = start + 1; i < n; i++) {
            if(account[i] * account[start] < 0) {
                account[i] += account[start];
                dfs(account, start + 1, cnt + 1);
                account[i] -= account[start];
            }
        }
    }
}
