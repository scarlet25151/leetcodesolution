public class sudoku_solver_37 {
    public void solveSudoku(char[][] board) {
        if (board.length == 0 || board.length != 9 || board[0].length != 9)
            return;
        solveSudokuDFS(board, 0, 0);
    }
    boolean solveSudokuDFS(char[][] board, int i, int j) {
        if (i == 9) return true;
        if (j >= 9) return solveSudokuDFS(board, i + 1, 0);
        if (board[i][j] == '.') {
            for (int k = 1; k <= 9; ++k) {
                board[i][j] = (char) (k + '0');
                if (isValid(board, i, j)) {
                    if (solveSudokuDFS(board, i, j + 1)) return true;
                }
                board[i][j] = '.';
            }
        } else {
            return solveSudokuDFS(board, i, j + 1);
        }
        return false;
    }
    boolean isValid(char[][] board, int i, int j) {
        for (int col = 0; col < 9; ++col) {
            if (col !=j && board[i][col] == board[i][j]) return false;
        }
        for (int row = 0; row < 9; ++row) {
            if (row != i && board[row][j] == board[i][j]) return false;
        }
        for (int row = i / 3 * 3; row < i /3 * 3 + 3; ++row) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; ++col) {
                if ((row != i || col != j) && board[row][col] == board[i][j]) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
    }
}
