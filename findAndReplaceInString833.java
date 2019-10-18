import java.util.Arrays;

public class findAndReplaceInString833 {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int n = S.length();
        int[] match = new int[n];
        Arrays.fill(match, -1);

        for (int i = 0; i < indexes.length; i++) {
            int idx = indexes[i];
            if (S.substring(idx, idx + sources[i].length()).equals(sources[i]))
                match[idx] = i;
        }
        StringBuilder res = new StringBuilder();
        int idx = 0;
        while (idx < n) {
            if(match[idx] >= 0) {
                res.append(targets[match[idx]]);
                idx += sources[match[idx]].length();
            } else {
                res.append(S.charAt(idx++));
            }
        }
        return res.toString();
    }

}
