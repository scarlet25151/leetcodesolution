import java.util.LinkedList;
import java.util.List;

public class combination_77 {
    private List<List<Integer>> output = new LinkedList<>();
    private int n, k;
    public List<List<Integer>> combine_solution1(int n, int k) {
        this.n = n;
        this.k = k;
        backtracking(1, new LinkedList<Integer>());
        return output;
    }

    public void backtracking(int first, LinkedList<Integer> cur) {
        if (cur.size() == k) {
            output.add(new LinkedList<>(cur));
        }
        for (int i = first; i < n + 1; ++i) {
            cur.add(i);
            backtracking(i + 1, cur);
            cur.removeLast();
        }
    }
}
