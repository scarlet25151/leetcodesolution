import java.util.*;

public class combination_sum {
    public List<List<Integer>> combination(int[] candidates, int target) {
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
            res.add(tmp); return;}
        for (int i = start; i < candidates.length;++i) {
            out.addLast(candidates[i]);
            combinationDFS(candidates, target - candidates[i], i, out, res);
            out.removeLast();
        }
    }
}
