import java.util.*;
public class NQueens_51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        String[] queens = new String[n];
        char[] queenline = new char[n];
        for (int i = 0; i < n; ++i)
            queenline[i] = '.';
        String queen_str = Arrays.toString(queenline);
        for (int i = 0; i < n; ++i) {
            queens[i] = queen_str;
        }
        helper(queens, 0, res);
        return res;
    }
    void helper(String[] queens, int curRow, List<List<String>> res) {
        int n = queens.length;
        if (curRow == n) {
            res.add(Arrays.asList(queens));
            return;
        }
        for (int j = 0; j < n; ++j) {
            if (isValid(queens, curRow, j)) {
                StringBuilder queen = new StringBuilder(queens[curRow]);
                queen.setCharAt(j, 'Q');
                helper(queens, curRow + 1, res);
                queen.setCharAt(j, '.');
            }
        }
    }
    boolean isValid(String[] queens, int i, int j) {
        for (int row = 0; row < i; ++row) {
            if(queens[row].charAt(j) == 'Q') return false;
        }
        for (int row = i - 1, col = j - 1; row >=0 && col >=0; --row, --col) {
            if (queens[row].charAt(col) == 'Q') return false;
        }
        for (int row = i - 1, col = j + 1; row >= 0 && col < queens.length; --row, ++col) {
            if (queens[row].charAt(col) == 'Q') return false;
        }
        return true;
    }
}
