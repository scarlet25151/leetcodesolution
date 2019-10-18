import javafx.util.Pair;

import java.util.*;

public class shortestDistanceFromAllBuilding317 {
    private final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return -1;
        int m = grid.length, n = grid[0].length;
        List<int[][]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int[][] dist = new int[m][n];
                    bfs(grid, dist, i, j);
                    list.add(dist);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                int sum = 0;
                for (int[][] dist : list) {
                    if (dist[i][j] == Integer.MAX_VALUE) {
                        sum = Integer.MAX_VALUE;
                        break;
                    }
                    sum += dist[i][j];
                }
                if (res > sum) res = sum;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void bfs(int[][] grid, int[][] dist, int i, int j) {
        int m = grid.length, n = grid[0].length;
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(i, j));
        dist[i][j] = 0;
        while (!queue.isEmpty()) {
            int x = queue.peek().getKey(), y = queue.peek().getValue();
            queue.poll();
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != 0
                        || dist[nx][ny] <= dist[x][y] + 1)
                    continue;
                dist[nx][ny] = dist[x][y] + 1;
                queue.offer(new Pair(nx, ny));
            }
        }
    }
    public static void main (String[] args) {
        int[][] grid = {{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
        int output = 7;
        shortestDistanceFromAllBuilding317 solution = new shortestDistanceFromAllBuilding317();
        int testOutput = solution.shortestDistance(grid);
        System.out.println(testOutput);
    }
}
