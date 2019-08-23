import java.util.regex.Pattern;

public class permutation_sequence {
    public String getPermutation(int n, int k) {
        String res = "";
        String num = "123456789";
        int[] f = new int[n];
        for (int i = 0; i < n; ++i) {
            f[i] = 1;
        }
        for (int i = 1; i < n; ++i) f[i] = f[i - 1] + i;
        --k;
        StringBuilder sb = new StringBuilder(num);
        for (int i = n; i >=1; --i) {
            int j = k / f[i - 1];
            k %= f[i - 1];
            res += sb.charAt(j);
            sb.deleteCharAt(j);
        }
        return res;
    }
}
