import java.util.Scanner;

public class multiply_string_43 {
    public static String multiply(String num1, String num2) {
        String res = "";
        int m = num1.length(), n = num2.length();
        int[] vals = new int[m + n];
        for (int l = 0; l < m + n; ++l)
            vals[l] = 0;
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1, sum = mul + vals[p2];
                vals[p1] += sum / 10;
                vals[p2] = sum % 10;
            }
        }
        int firstNonzero = 0;
        while (vals[firstNonzero] == 0) firstNonzero++;
        for (int j = firstNonzero; j < vals.length; ++j) {
            res += vals[j];
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String st1,st2;
        st1 = scanner.next();
        st2 = scanner.next();
        System.out.println(multiply(st1, st2));
    }
}
