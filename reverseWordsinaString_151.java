import java.util.Stack;

public class reverseWordsinaString_151 {
    public static String reverseWords(String s) {
        s = s.trim();
        String[] splitStrings = s.split("\\s+");
        Stack<String> reverse = new Stack<>();
        for (String str : splitStrings)
            reverse.push(str);
        String res = "";
        while (!reverse.isEmpty()) {
            res += reverse.pop() + " ";
        }
        return res.trim();
    }
    public static void main(String[] args) {
        String testInput = "  hello world!  ";
        System.out.println(reverseWords(testInput));
    }

}
