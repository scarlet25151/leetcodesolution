import java.util.Stack;

public class decodeString_394 {
    public String decodeString(String s) {
        Stack<String> bracketStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder res = new StringBuilder("");
        int numberCnt = 0;
        String copyStr = "";
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                numberCnt = 10 * numberCnt + s.charAt(i) - '0';
            else if (s.charAt(i) == '[') {
                bracketStack.push(copyStr);
                numStack.push(numberCnt);
                copyStr = "";
                numberCnt = 0;
            } else if (s.charAt(i) == ']') {
                int cnt = numStack.pop();
                String str = bracketStack.pop();
                for (int j = 0; j < cnt; ++j) str += copyStr;
                copyStr = str;
            } else
                copyStr += s.charAt(i);
        }
        return bracketStack.isEmpty() ? copyStr : bracketStack.peek();
    }

}
