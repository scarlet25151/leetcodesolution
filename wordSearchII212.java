import java.util.ArrayList;
import java.util.List;

public class wordSearchII212 {
    // tree dict
    private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static class TrieNode {
        TrieNode[] children;
        String str;
        TrieNode() {
            str = "";
            children = new TrieNode[26];
            for (TrieNode child : children) child = null;
        }
    }
    private static class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        public void insert(String s) {
            TrieNode node = root;
            for (char ch : s.toCharArray()) {
                int i = ch - 'a';
                if (node.children[i] == null)
                    node.children[i] = new TrieNode();
                node = node.children[i];
            }
            node.str = s;
        }
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (words.length == 0 || board.length == 0 || board[0].length == 0) return res;
        int m = board.length, n = board[0].length;
        boolean[][] isVisited = new boolean[m][n];
        Trie nodes = new Trie();
        for (String word : words)
            nodes.insert(word);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (nodes.root.children[board[i][j] - 'a'] != null) {
                    searchWord(board, nodes.root.children[board[i][j] - 'a'], i, j, isVisited, res);
                }
            }
        }
        return res;
    }
    private static void searchWord(char[][] board, TrieNode node, int i, int j,
                        boolean[][] isVisited, List<String> res) {
        if (!node.str.isEmpty()) {
            res.add(node.str);
            node.str = null;
        }
        isVisited[i][j] = true;
        for (int[] direction : directions) {
            int x = i + direction[0], y = j + direction[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length &&
                    !isVisited[x][y] && node.children[board[x][y] - 'a'] != null) {
                searchWord(board, node.children[board[x][y] - 'a'], x, y, isVisited, res);
            }
        }
        isVisited[i][j] = false;
    }
    private static void search(char[][] board, TrieNode node, int i, int j,
                               boolean[][] isVisited, List<String> res) {

    }
    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> res = findWords(board, words);
    }
}
