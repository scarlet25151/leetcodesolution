public class repeatStringMatch686 {
    public int repeatedStringMatch(String A, String B) {
        int m = A.length(), n = B.length();
        for (int i = 0; i < m; ++i){
             int j = 0;
             while (j < n && A.charAt((i + j) % m) == B.charAt(j)) ++j;
             if (j == n) return (i + j - 1) / m + 1;
        }
        return  -1;
    }
}
