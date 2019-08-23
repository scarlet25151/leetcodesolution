public class unique_pathIII_980 {
    int res;
    int[][] grid;
    int tr, tc;
    int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    int R, C;
    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;
        int todo = 0;
        int sr = 0, sc = 0;
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] != -1) {
                    todo ++;

                }
                if (grid[r][c] == 1) {
                    sr = r;
                    sc = c;
                }else if (grid[r][c] == 2) {
                    tr = r;
                    tc = c;
                }

            }
        }
        res = 0;
        dfs(sr, sc, todo);
        return res;
    }
    public void dfs(int r, int c, int todo) {
        todo --;
        if (todo < 0) return;
        if (r == tr && c == tc) {
            if (todo == 0) res++;
            return;
        }
        grid[r][c] = 3;
        for (int di = 0; di < 4; di++) {
            int nr = r + dir[di][0];
            int nc = c + dir[di][1];
            if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                if (grid[nr][nc] % 2 == 0) dfs(nr, nc, todo);
            }
        }
        grid[r][c] = 0;
    }
}
