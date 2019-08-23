import java.util.Scanner;

public class spiral_matrixII_59 {
    public static int[][] generateMatrix(int n) {
        boolean[][] visited = new boolean[n][n];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] res = new int[n][n];
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < n * n; ++i) {
            visited[r][c] = true;
            res[r][c] = i + 1;
            int cr = r + dir[di][0];
            int cc = c + dir[di][1];
            if (cr >=0 && cr < n && cc >= 0 && cc < n && !visited[cr][cc]) {
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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] res = generateMatrix(n);
    }
}
