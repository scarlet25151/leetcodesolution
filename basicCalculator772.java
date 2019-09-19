public class basicCalculator772 {
    public int calculate(String s) {
        int n = s.length(), num = 0, curRes = 0, res = 0;
        char op = '+';
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + ch - '0';
            } else if (ch == '(') {
                int j = i, cnt = 0;
                for (; i < n; i++) {
                    if (s.charAt(i) == '(') cnt++;
                    if (s.charAt(i) == ')') cnt--;
                    if (cnt == 0) break;
                }
                num = calculate(s.substring(j + 1, i));
            }
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || i == n - 1) {
                switch (op) {
                    case '+': curRes +=num; break;
                    case '-': curRes -=num; break;
                    case '*': curRes *=num; break;
                    case '/': curRes /=num; break;
                }
                if (ch == '+' || ch == '-' || i == n - 1) {
                    res += curRes;
                    curRes = 0;
                }
                op = ch;
                num = 0;
            }
        }
        return res;
    }
}
