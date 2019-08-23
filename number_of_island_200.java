import java.util.*;


public class number_of_island_200 {
    //dfs
    public static void find_islands(boolean[][] visited, char[][] grid,
                                    int i, int j) {
        if (i < 0 || i >= visited.length
                || j < 0 || j >= visited[0].length
                || grid[i][j] == '0' || visited[i][j])
            return;
        visited[i][j] = true;
        find_islands(visited, grid, i - 1, j);
        find_islands(visited, grid, i + 1, j);
        find_islands(visited, grid, i, j - 1);
        find_islands(visited, grid, i, j + 1);

    }
    public int numIslands(char[][] grid) {

        if (grid.length == 0) return 0;
        int res = 0, grid_h = grid.length, grid_w = grid[0].length;
        boolean visited[][] = new boolean[grid_h][grid_w];
        for (int i = 0; i < grid_h; ++i) {
            for (int j = 0; j < grid_w; ++j) {
                if (grid[i][j] == '0' || visited[i][j]) continue;
                find_islands(visited, grid, i, j);
                ++res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        boolean visited[][] = new boolean[1][1];
        System.out.println(visited[0][0]);
    }
}
