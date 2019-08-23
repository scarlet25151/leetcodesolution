public class permutation_sequence_60 {
    public String getPermutation(int n, int k) {
        String res = "";
        int [] factorial = new int[n];
        char[] num = new char[n];
        for (int i = 0; i < n; ++i) {
            factorial[i] = 1;
            num[i] = '1';
        }
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }
        for (int i = 0; i < n; ++i) {
            num[i] = (char)((i + 1) + '0');
        }
        k--;
        String numString = new String(num);
        StringBuilder sb = new StringBuilder(numString);
        for (int i = n; i >= 1; --i) {
            int j = k / factorial[i - 1];
            k %= factorial[i - 1];
            res += sb.charAt(j);
            sb.deleteCharAt(j);
        }
        return res;
    }
}
