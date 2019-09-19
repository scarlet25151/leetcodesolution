public class licenceKeyFormatting482 {
    public static String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder(S);
        while (sb.indexOf("-") > 0) {
            sb.deleteCharAt(sb.indexOf("-"));
        }
        sb = new StringBuilder(sb.toString().toUpperCase());
        int insertIdx = 0;
        int dashNum = 0;
        for (int i = 1; i * K + dashNum < sb.length(); ++i) {
            sb.insert(i * K + dashNum, "-");
            dashNum += 1;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "5F3Z-2e-9-w";
        int K = 4;
        System.out.print(licenseKeyFormatting(s, K));
    }
}
