import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.*;

public class combination_sum_II_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> out = new ArrayDeque<>();

        combinationDFS(candidates, target, 0, out, res);
        return res;
    }
    public void combinationDFS(int[] candidates,
                               int target,
                               int start,
                               Deque<Integer> out, List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0) {
            List<Integer> tmp = new ArrayList<>(out);
            Collections.sort(tmp);
            if (!res.contains(tmp)) res.add(tmp);
            return;}
        for (int i = start; i < candidates.length;++i) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            out.addLast(candidates[i]);
            combinationDFS(candidates, target - candidates[i], i + 1, out, res);
            out.removeLast();
        }
    }
}
