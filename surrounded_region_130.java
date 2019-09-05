public class surrounded_region_130 {
    public static void solve(char[][] board) {
        if (board.length == 0) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1)
                        && board[i][j] == 'O')
                    dfs(board, i, j);
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = (board[i][j] == '#' ? 'O' : 'X');
            }
        }
    }

    private static void dfs(char[][] board, int i, int j) {
        if (board[i][j] == 'O') {
            board[i][j] = '#';
            if (i > 0 && board[i - 1][j] == 'O')
                dfs(board, i - 1, j);
            if (i < board.length - 1 && board[i + 1][j] == 'O')
                dfs(board, i + 1, j);
            if (j > 0 && board[i][j - 1] == 'O')
                dfs(board, i, j - 1);
            if (j < board[i].length - 1 && board[i][j + 1] == 'O')
                dfs(board, i, j + 1);
        }
    }
    public static void main(String[] args) {
        char[][] testSample = {{'X', 'O', 'X'},
                                {'X', 'O', 'X'},
                                {'X', 'O', 'X'}};

        solve(testSample);
        for (char[] line : testSample) {
            System.out.println(String.valueOf(line));
        }
    }
}
