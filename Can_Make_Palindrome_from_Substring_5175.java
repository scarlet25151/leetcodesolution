import java.util.ArrayList;
import java.util.List;

public class Can_Make_Palindrome_from_Substring_5175 {
    private static int changeCost(String s) {
        int len = s.length();
        int res = 0;
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                res += Math.min(s.charAt(i), s.charAt(j)) - 'a' + 1;
        }
        return res;
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            String substring = s.substring(query[0], query[1] + 1);
            if (changeCost(substring) <= query[2])
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println("abcda".substring(0, 4));
        System.out.println(changeCost("abcda".substring(0, 4)));

    }
}
