public class implementTriePrelixTree208 {
    public class TrieNode {
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
    class Trie {
        TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
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

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int i = ch - 'a';
                if (node.children[i] == null) return false;
                node = node.children[i];
            }
            return node.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                int i = ch - 'a';
                if (node.children[i] == null) return false;
                node = node.children[i];
            }
            return true;
        }
    }
}
