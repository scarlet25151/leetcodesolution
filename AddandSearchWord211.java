public class AddandSearchWord211 {
    class WordDictionary {
        private class TrieNode {
            boolean isWord;
            TrieNode[] children;
            TrieNode() {
                children = new TrieNode[26];
                isWord = false;
            }
        }
        TrieNode root;
        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode p = root;
            for (char ch : word.toCharArray()) {
                int i = ch - 'a';
                if (p.children[i] == null)
                    p.children[i] = new TrieNode();
                p = p.children[i];
            }
            p.isWord = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return searchWord(word, root, 0);
        }
        private boolean searchWord(String word, TrieNode p, int i) {
            if (i == word.length()) return p.isWord;
            if (word.charAt(i) == '.') {
                for (TrieNode node : p.children) {
                    if (node != null && searchWord(word, node, i + 1)) return true;
                }
                return false;
            } else {
                return p.children[word.charAt(i) - 'a'] != null
                        && searchWord(word, p.children[word.charAt(i) - 'a'], i + 1);
            }
        }
    }
}
