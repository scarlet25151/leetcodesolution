import java.util.*;

public class longest_valid_parentheses  {


    //dynamic programming algorithm
    public static int longestValidParentheses(String s) {
        int[] res = new int[s.length()];
        int max_len = 0;
        for (int i = 0; i < s.length(); i++) {
            res[i] = 0;

            if (i > 0 && s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(')
                    res[i] = (i >= 2 ? res[i - 2] : 0) + 2;
                else if (i - res[i - 1] > 0 && s.charAt(i - res[i - 1] - 1) == '(')
                    res[i] = res[i - 1] +
                            (i - res[i - 1] > 2 ? res[i - res[i - 1] - 2] : 0) + 2;
                max_len = Math.max(max_len, res[i]);
            }
        }
        return max_len;
    }
    //
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(longestValidParentheses(s));

    }
}
