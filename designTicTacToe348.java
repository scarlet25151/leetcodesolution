import java.lang.reflect.Array;
import java.util.Arrays;

public class designTicTacToe348 {
    public int[][] board;
    public designTicTacToe348(int n) {
        board = new int[n][n];
        for (int[] boardLine : board)
            Arrays.fill(boardLine, 0);
    }
    public int move(int row, int col, int player) {
        board[row][col] = player;
        int i = 0, j = 0, n = board.length;
        for (j = 1; j < n; ++j) {
            if (board[row][j] != board[row][j - 1]) break;
        }
        if (j == n) return player;
        for (i = 1; i < n; ++i) {
            if (board[i][col] != board[i - 1][col]) break;
        }
        if (i == n) return player;
        if (row == col) {
            for (i = 1; i < n; ++i) {
                if (board[i][i] != board[i - 1][i - 1]) break;
            }
            if (i == n) return player;
        }
        if (row + col == n - 1) {
            for (j = 1; j < n; ++j) {
                if (board[n - j - 1][j] != board[n - j][j - 1]) break;
            }
            if (j == n) return player;
        }
        return 0;
    }
}
