public class palindromicSubstrings647 {
    private int res = 0;
    public int countSubstrings(String s) {
        int n  = s.length();
        for (int i = 0; i < n; i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return res;
    }
    private void helper(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            res++;
            i--;
            j++;
        }
    }
    public int countSubstrings_mannachersAlogrithm(String S) {
        char[] A = new char[2 * S.length() + 3];
        A[0] = '@';
        A[1] = '#';
        A[A.length - 1] = '$';
        int t = 2;
        for (char c : S.toCharArray()) {
            A[t++] = c;
            A[t++] = '#';
        }
        int[] Z = new int[A.length];
        int center = 0, right = 0;
        for (int i = 1; i < Z.length - 1; i++) {
            if (i < right) {
                Z[i] = Math.min(right - i, Z[2 * center - i]);
            }
            while (A[i + Z[i] + 1] == A[i - Z[i] - 1]) {
                Z[i] ++;
            }
            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }
        }
        int res = 0;
        for (int z : Z) res += (z + 1) / 2;
        return res;
    }
}
