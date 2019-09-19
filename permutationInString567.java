public class permutationInString567 {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length(), left = 0;
        int[] m = new int[128];
        for (char ch : s1.toCharArray()) {
            ++m[ch];
        }
        for (int right = 0; right < n2; ++right) {
            if (--m[s2.charAt(right)] < 0) {
                while (++m[s2.charAt(left++)] != 0) {}

            } else if (right - left + 1 == n1) return true;
        }
        return n1 == 0;
    }
}
