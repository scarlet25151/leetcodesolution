import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class combinationSumIII216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> out = new Stack<>();
        combinationSumDFS(k, n, 1, out, res);
        return res;
    }

    private void combinationSumDFS(int k, int n, int level,
                                   Stack<Integer> out, List<List<Integer>> res) {
        if (n < 0) return;
        if (n == 0 && out.size() == k) res.add(new ArrayList<>(out));
        for (int i = level; i <= 9; i++) {
            out.push(i);
            combinationSumDFS(k, n - i, i + 1, out, res);
            out.pop();
        }
    }
}
