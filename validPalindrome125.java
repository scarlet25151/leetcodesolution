public class validPalindrome125 {
    public static boolean isPalindrome(String s) {
        if (s.equals("")) return true;
        String concatenateString = "";
        for (char ch : s.toCharArray()) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') ||
                    (ch >= '0' && ch <= '9')) {
                concatenateString += ch;
            }
        }
        concatenateString = concatenateString.toLowerCase();
        int n = concatenateString.length();
        for (int i = 0; i < n / 2; ++i) {
            if (concatenateString.charAt(i) != concatenateString.charAt(n - i - 1))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String testInput = "race a car";
        System.out.println(isPalindrome(testInput));
    }
}
