import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class palindromePartition131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        Stack<String> out = new Stack<>();
        dfs(s, 0, out, res);
        return res;
    }
    private void dfs(String s, int start,
                     Stack<String> out, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(out));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (!isPalindrome(s, start, i)) continue;
            out.push(s.substring(start, i));
            dfs(s, i + 1, out, res);
            out.pop();
        }
    }
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }

}
