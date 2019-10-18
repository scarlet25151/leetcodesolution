import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class prefixToPostfix {
    static boolean isOp(char x) {
        switch (x) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
        }
        return false;
    }
    static String pre2post(String pre) {
        Stack<String> stack = new Stack<>();
        int len = pre.length();
        for (int i = len - 1; i >= 0; i--) {
            if (isOp(pre.charAt(i))) {
                String op1 = stack.pop();
                String op2 = stack.pop();

                String tmp = op1 + op2 + pre.charAt(i);
                stack.push(tmp);
            } else {
                stack.push(pre.charAt(i) + "");
            }
        }
        return stack.peek();
    }
    public static List<String> prefixToPostfix(List<String> prefixes) {
        // Write your code here
        List<String> postfixes = new ArrayList<>();
        for (String prefix : prefixes) {
            postfixes.add(pre2post(prefix));
        }
        return postfixes;
    }
}
