import java.util.Arrays;

public class isomorphicString205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] char1 = new int[26], char2 = new int[26];
        int[] digit1 = new int[10], digit2 = new int[10];
        Arrays.fill(char1, 0);
        Arrays.fill(char2, 0);
        Arrays.fill(digit1, 0);
        Arrays.fill(digit2, 0);

        int n = s.length();
        for (int i = 0; i < n; i ++) {
        }
        Arrays.sort(char1);
        Arrays.sort(char2);
        for (int i = 0; i < 26; ++i) {
            if (char1[i] != char2[i]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        isomorphicString205 instant = new isomorphicString205();
        String s = "paper", t = "title";
        System.out.print(instant.isIsomorphic(s, t));
    }
}
