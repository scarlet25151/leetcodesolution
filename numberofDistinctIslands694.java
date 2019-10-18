import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class numberofDistinctIslands694 {
    private final int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public int numDistinctIslands(int[][] grid) {
        if (grid.length ==0 || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        Set<String> res = new HashSet<>();
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !isVisited[i][j]) {
                    Set<String> output = new HashSet<>();
                    dfs(grid, i, j, i, j, isVisited, output);
                    StringBuilder outString = new StringBuilder("");
                    for (String str : output) {
                        outString.append(str + "_");
                    }
                    res.add(outString.toString());
                }
            }
        }
        return res.size();
    }
    private void dfs(int[][] grid, int x0, int y0, int i, int j,
                    boolean[][] isVisited, Set<String> out) {
        int m = grid.length, n = grid[0].length;
        isVisited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n ||
                    grid[x][y] == 0 || isVisited[x][y])
                continue;
            String str = String.valueOf(x - x0) + "_" + String.valueOf(y - y0);
            out.add(str);
            dfs(grid, x0, y0, x, y, isVisited, out);
        }
    }
}
