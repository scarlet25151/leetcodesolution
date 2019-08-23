import java.util.ArrayList;
import java.util.List;

public class generate_parentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", 0, 0, n);
        return res;
    }
    public void helper(List<String> res, String cur,
                       int open,
                       int close,
                       int max) {
        if (cur.length() == max * 2) {
            res.add(cur);
            return;
        }
        if (open < max)
            helper(res, cur + "(", open + 1, close, max);
        if (close < open)
            helper(res, cur + ")", open, close + 1, max);
    }
}
