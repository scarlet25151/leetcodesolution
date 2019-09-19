import java.util.Arrays;

public class reorgnizedString767 {
    public String reorganizeString(String S) {
        int n = S.length(), idx = 1;
        StringBuilder sb = new StringBuilder(S);
        int[] cnt = new int[26];
        for (char ch : S.toCharArray()) cnt[ch - 'a'] += 1000;
        for (int i = 0; i < cnt.length; ++i) cnt[i] += i;
        Arrays.sort(cnt);
        for (int num : cnt) {
            int frequency = num / 1000;
            char ch = (char) ('a' + (num % 1000));
            if (frequency > (n + 1) / 2) return "";
            for (int i = 0; i < frequency; ++i) {
                if (idx >= n) idx = 0;
                sb = sb.replace(idx, idx + 1, String.valueOf(ch));
                idx += 2;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        reorgnizedString767 solution = new reorgnizedString767();
        String input = "aab";
        System.out.print(solution.reorganizeString(input));
    }
}
