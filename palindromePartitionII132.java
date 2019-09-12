public class palindromePartitionII132 {
    public int minCut(String s) {
        if (s.isEmpty()) return 0;
        int n = s.length();
        boolean[][] dpFindPalindrome = new boolean[n][n];
        int[] dpFindMinCut = new int[n];
        for (int i = 0; i < n; ++i) {
            dpFindMinCut[i] = i;
            for (int j = 0; j <= i; ++j) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dpFindPalindrome[j + 1][i - 1])) {
                    dpFindPalindrome[j][i] = true;
                    dpFindMinCut[i] = j == 0 ? 0 : Math.min(dpFindMinCut[i], dpFindMinCut[j - 1] + 1);
                }
            }
        }
        return dpFindMinCut[n - 1];
    }
}
