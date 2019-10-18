import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class raceCar818 {
    public int racecar(int target) {
        int res = 0;
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        Set<String> isVisited = new HashSet<>();

        queue.offer(new Pair(0, 1));
        isVisited.add("0,1");
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int pos = queue.peek().getKey(), speed = queue.peek().getValue();
                queue.poll();
                if (pos == target) return res;
                int newPos = pos + speed;
                int newSpeed = speed * 2;
                String state = String.valueOf(newPos) + "," + String.valueOf(newSpeed);
                if (!isVisited.contains(state) && newPos > 0 && newPos < target * 2) {
                    isVisited.add(state);
                    queue.offer(new Pair(newPos, newSpeed));
                }

                newPos = pos;
                newSpeed = speed > 0 ? -1 : 1;
                state = String.valueOf(newPos) + "," + String.valueOf(newSpeed);
                if (!isVisited.contains(state) && newPos > 0 && newPos < target * 2) {
                    isVisited.add(state);
                    queue.offer(new Pair(newPos, newSpeed));
                }
            }
            res++;
        }
        return -1;
    }
    public int racecar_dp(int target) {
        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;
            int j = 1, cnt1 = 1;
            for (; j < i; j = (1 << ++cnt1) - 1) {
                for (int k = 0, cnt2 = 0; k < j; k = (1 << ++cnt2) - 1) {
                    dp[i] = Math.min(dp[i], cnt1 + 1 + cnt2 + 1 + dp[i - (j - k)]);
                }
            }
            dp[i] = Math.min(dp[i], cnt1 + (i == j ? 0 : 1 + dp[j - i]));
        }
        return dp[target];
    }
}
