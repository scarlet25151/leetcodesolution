import java.util.*;

public class removeInvalidParentheses301 {
    public static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Set<String> isVisited = new HashSet<>();
        isVisited.add(s);
        Queue<String> queue = new ArrayDeque<>();
        queue.add(s);
        boolean found = false;
        while(!queue.isEmpty()) {
            String curString = queue.poll();
            if (isValid(curString)) {
                res.add(curString);
                found = true;
            }
            if (found) continue;
            for (int i = 0; i < curString.length(); i++) {
                if (curString.charAt(i) != '(' &&
                        curString.charAt(i) != ')') continue;
                StringBuilder stringBuilder = new StringBuilder(curString);
                stringBuilder.deleteCharAt(i);
                String str = stringBuilder.toString();
                if (!isVisited.contains(str)) {
                    queue.offer(str);
                    isVisited.add(str);
                }
            }
        }
        return res;
    }

    private static boolean isValid(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') cnt++;
            else if (s.charAt(i) == ')' && -- cnt < 0) return false;
        }
        return cnt == 0;
    }
    public static void main(String[] args) {
        String testInput = "()())()";
        List<String> res = removeInvalidParentheses(testInput);
    }
}
