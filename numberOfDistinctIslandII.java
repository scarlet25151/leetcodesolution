import java.util.*;

public class numberOfDistinctIslandII {
    int[][] grid;
    boolean[][] isVisited;
    ArrayList<Integer> shape;

    private void explore(int r, int c) {
        if ((r < 0 || r >= grid.length)
                || (c < 0 || c >= grid[0].length)
                || isVisited[r][c]) return;
        shape.add(r * grid[0].length + c);
        explore(r + 1, c);
        explore(r - 1, c);
        explore(r, c + 1);
        explore(r, c - 1);
    }

    private String canonical(List<Integer> shape) {
        String res = "";
        int lift = grid.length + grid[0].length;
        int[] out = new int[shape.size()];
        int[] xs = new int[shape.size()];
        int[] ys = new int[shape.size()];

        for (int c = 0; c < 8; c++) {
            int t = 0;
            for (int z : shape) {
                int x = z / grid[0].length;
                int y = z % grid[0].length;

                xs[t] = (c <= 1) ? x : (c <= 3) ? -x : (c <= 5) ? y : -y;
                ys[t++] = (c <= 3) ? ((c % 2 == 0) ? y : -y) : ((c % 2 == 0) ? x : -x);
            }

            int mx = xs[0], my = ys[0];
            for (int x : xs) mx = Math.min(mx, x);
            for (int y : ys) my = Math.min(my, y);

            for (int j = 0; j < shape.size(); j++)
                out[j] = (xs[j] - mx) * lift + (ys[j] - my);
            Arrays.sort(out);
            String candidate = Arrays.toString(out);
            if (res.compareTo(candidate) < 0) res = candidate;
        }
        return res;
    }

    public int numDistinctIsland2(int[][] grid) {
        this.grid = grid;
        this.isVisited = new boolean[grid.length][grid[0].length];
        Set<String> shapes = new HashSet<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                shape = new ArrayList();
                explore(r, c);
                if (!shape.isEmpty()) {
                    shapes.add(canonical(shape));
                }
            }
        }
        return shapes.size();
    }
}