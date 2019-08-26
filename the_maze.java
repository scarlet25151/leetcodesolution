import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class the_maze {
    private static int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public boolean hasPath_dfs(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 || maze[0].length == 0) return true;
        int m = maze.length, n = maze[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i)
            Arrays.fill(dp[i], -1);
        return backtracking(maze, dp, start[0], start[1],
                destination[0], destination[1]);
    }
    private boolean backtracking(int[][] maze, int[][] dp,
                         int i, int j, int di, int dj) {
        if (i == di && j == dj) return true;
        if (dp[i][j] != -1) return dp[i][j] == 0;
        boolean res = false;
        int m = maze.length, n = maze[0].length;
        maze[i][j] = -1;
        for (int[] dir : dirs) {
            int x = i, y = j;
            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
                x += dir[0]; y += dir[1];
            }
            x -= dir[0]; y -= dir[1];
            if (maze[x][y] != -1) {
                res = backtracking(maze, dp, x, y, di, dj);
            }
        }
        dp[i][j] = res ? 1 : 0;
        return res;
    }
    public class Points{
        int x, y;
        Points(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 || maze[0].length == 0) return true;
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Deque<Points> q = new ArrayDeque<>();
        Points s_p = new Points(start[0], start[1]);
        Points d_p = new Points(destination[0], destination[1]);
        q.push(s_p);
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            Points t = q.removeFirst();
            if (t.x == destination[0] && t.y == destination[1]) return true;
            for (int[] dir : dirs) {
                int x = t.x, y = t.y;
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x +=dir[0]; y += dir[1];
                }
                x -= dir[0]; y -= dir[1];
                if (!visited[x][y]) {
                    visited[x][y] = true;
                    q.push(new Points(x, y));
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }
}
