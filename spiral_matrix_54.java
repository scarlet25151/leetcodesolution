import java.util.ArrayList;
import java.util.List;

public class spiral_matrix_54 {
    public List<Integer> spiralOrder_solution1_simulation(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int r = 0, c = 0, di = 0;
        for (int i= 0; i < R * C; ++i) {
            res.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dir[di][0];
            int cc = c + dir[di][1];
            if (0 <= cr && cr < R && 0 <=cc && cc < C && !seen[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dir[di][0];
                c += dir[di][1];
            }
        }
        return res;
    }
}
