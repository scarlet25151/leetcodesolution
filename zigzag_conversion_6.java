import java.util.*;
public class zigzag_conversion_6 {
    public static String convert(String s, int numRows) {
        if (numRows <=1) return s;
        String res = "";
        int size = 2 * numRows - 2;
        for (int i = 0; i < numRows; ++i) {
            for (int j = i; j < s.length(); j += size) {
                res += s.charAt(j);
                int tmp = j + size - 2 * i;
                if (i !=0 && i != numRows - 1 && tmp < s.length())
                    res += s.charAt(tmp);
            }
        }
        return res;
    }
    public static String convert2(String s, int numRows) {
        return "";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int i = scanner.nextInt();
        System.out.println(convert(s, i));
    }
}
