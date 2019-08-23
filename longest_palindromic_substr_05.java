import java.util.Scanner;

public class longest_palindromic_substr_05 {
    //Manacher 解法
    public static String manacher(String s) {
        //定义新的辅助字符 Insert '$#'
        String t = "$#";
        for (int i = 0; i < s.length(); ++i) {
            t += s.charAt(i);
            t += "#";
        }
        //构造辅助数组 Process t
        int process[] = new int[t.length()];
        for (int i = 0; i < process.length; ++i)
            process[i] = 0;
        int mx = 0, id = 0, resLen = 0, resCenter = 0;
        for (int i = 1; i < t.length(); ++i) {
            process[i] = mx > i ? Math.min(process[2 * id - i], mx - i) : 1;
            while(t.charAt(i + process[i]) == t.charAt(i - process[i])) ++process[i];
            if (mx < i + process[i]) {
                mx = i + process[i];
                id = i;
            }
            if (resLen < process[i]) {
                resLen = process[i];
                resCenter = i;
            }
        }
        return s.substring((resCenter - resLen) / 2, (resCenter + resLen) / 2 - 1);
    }

    public static String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        boolean dp[][] = new boolean[s.length()][s.length()];
        int left = 0, right = 0, len = 0;
        for (int i = 0; i < s.length(); ++i) {
            dp[i][i] = true;
            for (int j = 0; j < i; ++j) {
                dp[j][i] = (s.charAt(j) == s.charAt(i) && (i - j < 2 || dp[j + 1][i - 1]));
                if (dp[j][i] && len < i - j + 1) {
                    right = i; left = j; len = i - j + 1;
                }
            }
        }
        return s.substring(left, right + 1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(manacher(s));
    }
}

