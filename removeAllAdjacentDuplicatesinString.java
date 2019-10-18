import java.util.Stack;

public class removeAllAdjacentDuplicatesinString {
    public String removeDuplicates(String s, int k) {
        Stack<Character> str = new Stack<>();
        for (char ch : s.toCharArray()) {
            str.push(ch);
            if (str.size() >= k) {
                boolean isSame = true;
                char compare = str.peek();
                for (int i = str.size() - 1; i >= str.size() - k; i--) {
                    if (str.get(i) != compare) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    for (int i = 0; i < k; i++) {
                        str.pop();
                    }
                }
            }
        }
        StringBuilder res = new StringBuilder("");
        while (!str.isEmpty()) {
            res.append(str.pop());
        }
        res.reverse();
        return res.toString();
    }
    public static void main(String[] args) {
        String s = "pbbcggttciiippooaais";
        int k = 2;
        removeAllAdjacentDuplicatesinString obj = new removeAllAdjacentDuplicatesinString();
        String res = obj.removeDuplicates(s, k);
    }
}
