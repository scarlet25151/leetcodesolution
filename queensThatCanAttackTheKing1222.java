import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class queensThatCanAttackTheKing1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        boolean[][] board = new boolean[8][8];
        for (int[] queen : queens) {
            board[queen[0]][queen[1]] = true;
        }
        List<List<Integer>> queensPos = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int x = king[0] + i, y = king[1] + j;
                while (Math.min(x, y) >= 0 && Math.max(x, y) < 8) {
                    if (board[x][y]) {
                        queensPos.add(new ArrayList<>(Arrays.asList(x, y)));
                    }
                    x += i;
                    y += j;
                }
            }
        }
        return queensPos;
    }

}
