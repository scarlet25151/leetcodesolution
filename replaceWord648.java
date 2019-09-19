import java.util.Iterator;
import java.util.List;

public class replaceWord648 {
    private class TrieNode {
        TrieNode[] children;
        boolean isWord;
        TrieNode () {
            isWord = false;
            children = new TrieNode[26];
            for (TrieNode child : children) {
                child = null;
            }
        }
    }
    private class Trie {
        TrieNode root;
        public Trie () {
            root = new TrieNode();
        }
        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int i = ch - 'a';
                if (node.children[i] == null)
                    node.children[i] = new TrieNode();
                node = node.children[i];
            }
            node.isWord = true;
        }
        public String findPrefix(String word) {
            String cur = "";
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int i = ch - 'a';
                if (node.children[i] == null) break;
                cur += ch;
                node = node.children[i];
                if (node.isWord) return cur;
            }
            return word;
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        String res = "", cur = "";
        Trie trie = new Trie();
        for (String word : dict) {
            trie.insert(word);
        }

        for(int i = 0; i < sentence.length(); ++i) {
            cur += sentence.charAt(i);
            if (sentence.charAt(i) == ' ' || i == sentence.length() - 1) {
                if (!res.equals("")) res += ' ';
                res += trie.findPrefix(cur.substring(0, cur.length() - 1));
                cur = "";
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
