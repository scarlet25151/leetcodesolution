import java.util.*;

public class reverseSubstringBetweenEachParentheses5190 {
    public String reverseParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        List<Character> tempStore = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                while (stack.peek() != '(') {
                    tempStore.add(stack.removeLast());
                }
                for (char ch1 : tempStore) {
                    stack.add(ch1);
                }
            }
            stack.add(ch);
        }
        String res = "";
        while (!stack.isEmpty())
            res += stack.removeFirst();
        return res;
    }
}
