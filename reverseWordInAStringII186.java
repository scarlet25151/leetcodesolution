import java.util.Stack;

public class reverseWordInAStringII186 {
    public void reverseWords(char[] s) {
        int left = 0, n = s.length;
        for (int i = 0; i <= n; i++) {
            if (i == n || s[i] == ' ') {
                reverse(s, left, i - 1);
                
            }
        }
    }
    public void reverse(char[] str, int left, int right) {
        while (left < right) {
            char t = str[left];
            str[left] = str[right];
            str[right] = t;
            left++;right--;
        }
    }
}
