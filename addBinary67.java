public class addBinary67 {
    public String addBinary(String a, String b) {
        String res = "";
        int na = a.length(), nb = b.length();
        int n = Math.max(na, nb);
        boolean carry = false;
        if (na > nb) {
            for (int i = 0; i < na - nb; ++i) {
                b = "0" + b;
            }
        }
        if (nb > na) {
            for (int i = 0; i < nb - na; ++i) {
                a = "0" + a;
            }
        }
        for (int i = n - 1; i>=0; --i) {
            int computeDigit = 0;
            if (carry) computeDigit = a.charAt(i) - '0' + b.charAt(i) - '0' + 1;
            else computeDigit = a.charAt(i) - '0' + b.charAt(i) - '0';
            if (computeDigit == 0) {
                res = "0" + res;
                carry = false;
            }
            if (computeDigit == 1) {
                res = "1" + res;
                carry = false;
            }
            if (computeDigit == 2) {
                res = "0" + res;
                carry = true;
            }
            if (computeDigit == 3) {
                res = "1" + res;
                carry = true;
            }
        }
        if (carry) res = "1" + res;
        return res;
    }
}
