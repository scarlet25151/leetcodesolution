import java.util.*;

public class word_ladder_126 {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();

        Set<String> dict = new HashSet<>(wordList);

        List<String> p = new ArrayList<>();
        p.add(beginWord);

        Deque<List<String>> paths = new ArrayDeque<>();
        paths.add(p);

        int level = 1, minLevel = Integer.MAX_VALUE;
        Set<String> words = new HashSet<>();

        while (!paths.isEmpty()) {
            List<String> a = paths.peek(); paths.pop();
            if (a.size() > level) {
                for (String word : words) dict.remove(word);
                words.clear();
                level = a.size();
                if (level > minLevel) break;
            }
            String last = a.get(a.size() - 1);
            for (int i = 0; i < last.length(); ++i) {
                char[] newLast = last.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ++ch) {
                    newLast[i] = ch;

                    if (!dict.contains(String.copyValueOf(newLast))) continue;
                    words.add(String.copyValueOf(newLast));
                    List<String> nextPath = a;
                    nextPath.add(String.copyValueOf(newLast));
                    if (String.copyValueOf(newLast).equals(endWord)) {
                        res.add(nextPath);
                        minLevel = level;
                    } else paths.add(nextPath);
                }
            }

        }
        return res;
    }
    public static void main (String[] args) {
        String beginword = "hit", endword = "dog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        List<List<String>> res = findLadders(beginword, endword, wordList);
    }
}
