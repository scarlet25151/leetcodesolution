public class one_edit_distance_161 {
    boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); ++i) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) return s.substring(i + 1) == t.substring(i + 1);
                else if (s.length() < t.length()) return s.substring(i) == t.substring(i + 1);
                else return s.substring(i + 1) == t.substring(i);
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}
