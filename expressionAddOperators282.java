import java.util.ArrayList;
import java.util.List;

public class expressionAddOperators282 {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(num, target, 0, 0, "", res);
        return res;
    }
    private void dfs(String num, int target,
                    long diff, long curNum,
                    String out, List<String> res) {
        if (num.length() == 0 && curNum == target) {
            res.add(out);
            return;
        }
        for (int i = 1; i <= num.length(); i++) {
            String cur = num.substring(0, i);
            if (cur.length() > 1 && cur.charAt(0) == '0') return;
            String next = num.substring(i);
            if (out.length() > 0) {
                dfs(next, target,
                        Long.parseLong(cur),
                        curNum + Long.parseLong(cur),
                        out + "+" + cur, res);
                dfs(next, target,
                        -Long.parseLong(cur),
                        curNum - Long.parseLong(cur),
                        out + "-" + cur, res);
                dfs(next, target, diff * Long.parseLong(cur),
                        (curNum - diff) + diff * Long.parseLong(cur),
                        out + "*" + cur, res);
            } else {
                dfs(next, target,
                        Long.parseLong(cur),
                        Long.parseLong(cur),
                        cur, res);
            }
        }
    }
    public static void main(String[] args) {
        expressionAddOperators282 solution = new expressionAddOperators282();
        String num = "3456237490";
        int target = 9191;
        List<String> list = solution.addOperators(num, target);
    }
}
