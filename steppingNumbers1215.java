import java.util.*;

public class steppingNumbers1215 {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            dfs(low, high, i, res);
        }
        Collections.sort(res);
        return res;
    }


    private void bfs(int low, int high, int num, List<Integer> res) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        while(!queue.isEmpty()) {
            int stepNum = queue.poll();
            if (stepNum >= low && stepNum <= high) {
                res.add(stepNum);
            }
            if (stepNum == 0 || stepNum > high) {
                continue;
            }
            int lastDIgit = stepNum % 10;
            int stepNumA = stepNum * 10 + lastDIgit - 1;
            int stepNumB = stepNum * 10 + lastDIgit + 1;
            if (lastDIgit == 0) {
                queue.offer(stepNumB);
            } else if (lastDIgit == 9) {
                queue.offer(stepNumA);
            } else {
                queue.offer(stepNumA);
                queue.offer(stepNumB);
            }
        }
    }

    private void dfs(int low, int high, long cur, List<Integer> res) {
        if (cur >= low && cur <= high) res.add((int)cur);
        if (cur == 0 || cur > high) return;

        long last = cur%10, inc = cur*10 + last + 1, dec = cur*10 + last - 1;

        if (last == 0) dfs(low, high, inc, res);
        else if (last == 9) dfs(low, high, dec, res);
        else {
            dfs(low, high, inc, res);
            dfs(low, high, dec, res);
        }
    }

}
