import java.util.Stack;

public class basicCalculator {
    public int calculateI(String s) {
        int res = 0, num = 0, sign = 1, n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num = 10 * num + (ch - '0');
            } else if (ch == '(') {
                int start = i, cnt = 0;
                for (; i < n; i++) {
                    if (s.charAt(i) == '(') cnt++;
                    if (s.charAt(i) == ')') cnt--;
                    if (cnt == 0) break;
                }
                num = calculateI(s.substring(start + 1, i));
            }
            if (ch == '+' || ch == '-' || i == n - 1) {
                res += sign * num;
                num = 0;
                sign = (ch == '+') ? 1 : -1;
            }
        }
        return res;
    }

    public int calculateII(String s) {
        long res = 0, num = 0, n = s.length();
        char op = '+';
        Stack<Long> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch >= '0') {
                num = num * 10 + ch - '0';
            }
            if ((ch < '0' && ch != ' ') || i == n - 1) {
                if (op == '+') stack.push(num);
                if (op == '-') stack.push(-num);
                if (op == '*' || op == '/') {
                    long tmp = (op == '*') ? stack.pop() * num : stack.pop() / num;
                    stack.push(tmp);
                }
                op = ch;
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return (int) res;
    }
}
