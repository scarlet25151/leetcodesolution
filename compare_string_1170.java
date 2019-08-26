import java.util.Arrays;

public class compare_string_1170 {
    public int countSmall(String s) {
        char[] ch = s.toCharArray();
        int id = 0, dif = 26;
        for (int i = 0; i < ch.length; ++i) {
            if ((int) ch[i] - 'a' < dif) {
                dif = (int) ch[i] - 'a';
                id = i;
            }
        }
        int count = 0;
        for (int i = 0; i < ch.length; ++i) {
            if (ch[i] == ch[id]) count ++;
        }
        return count;
    }
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] qcount = new int[queries.length], wcount = new int[words.length];
        for (int i = 0; i < queries.length; ++i) {
            qcount[i] = countSmall(queries[i]);
        }
        for (int i = 0; i < words.length; ++i) {
            wcount[i] = countSmall(words[i]);
        }
        int[] res = new int[qcount.length];
        Arrays.fill(res, 0);
        for (int i = 0; i < qcount.length; ++i) {
            for (int j = 0; j < words.length; ++j) {
                if (qcount[i] < wcount[j]) {
                    res[i] ++;
                }
            }
        }
        return res;
    }
}
