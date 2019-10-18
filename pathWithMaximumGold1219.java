public class pathWithMaximumGold1219 {
    private static final int[] d = {0, 1, 0, -1, 0};
    public int getMaximumGold(int[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(grid, i, j, 0, isVisited));
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j, int sum, boolean[][] isVisited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
                || grid[i][j] == 0 || isVisited[i][j]) {
            return sum;
        }
        sum += grid[i][j];
        isVisited[i][j] = true;
        int mx = 0;
        for (int k = 0; k < 4; k ++) {
            mx = Math.max(mx, dfs(grid, i + d[k], j + d[k + 1], sum, isVisited));

        }
        isVisited[i][j] = false;
        return mx;
    }
}
