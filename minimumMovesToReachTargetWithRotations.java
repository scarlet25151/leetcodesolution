import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class minimumMovesToReachTargetWithRotations {
    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        SnakePos src = new SnakePos(new Cell(0, 0), new Cell(0, 1));
        SnakePos dst = new SnakePos(new Cell(n - 1, n - 2), new Cell(n - 1, n - 1));

        HashSet<String> isVisited = new HashSet<>();
        Queue<SnakePos> queue = new LinkedList<>();

        queue.add(src);
        isVisited.add(src.getPos());

        ArrayList<SnakePos> nextMoves = new ArrayList<>();
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                SnakePos top = queue.remove();
                if (top.equals(dst)) {
                    return steps;
                }

                nextMoves.clear();
                nextMoves.add(tryMoveRight(top, grid));
                nextMoves.add(tryMoveDown(top, grid));
                nextMoves.add(tryMoveClockwise(top, grid));
                nextMoves.add(tryMoveCounterClockwise(top, grid));

                for (SnakePos next : nextMoves) {
                    if (next != null && !isVisited.contains(next)) {
                        isVisited.add(next.getPos());
                        queue.add(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    public SnakePos tryMoveRight(SnakePos curr, int[][] grid) {
        SnakePos nextPos = new SnakePos(
                new Cell(curr.c1.r, curr.c1.c + 1),
                new Cell(curr.c2.r, curr.c2.c + 1)
        );
        if (valid(nextPos, grid)) {
            return nextPos;
        }
        return null;
    }

    public SnakePos tryMoveDown(SnakePos curr, int[][] grid) {
        SnakePos nextPos = new SnakePos(
                new Cell(curr.c1.r + 1, curr.c1.c),
                new Cell(curr.c2.r + 1, curr.c2.c)
        );
        if (valid(nextPos, grid)) {
            return nextPos;
        }
        return null;
    }

    public SnakePos tryMoveClockwise(SnakePos curr, int[][] grid) {
        if (curr.c1.r == curr.c2.r) {
            SnakePos next = new SnakePos(
                    new Cell(curr.c1.r, curr.c1.c),
                    new Cell(curr.c2.r + 1, curr.c2.c - 1)
            );
            if (valid(next.c2, grid)
                    && (valid(new Cell(curr.c1.r + 1, curr.c2.c + 1), grid))) {
                return next;
            }
        }
        return null;
    }

    public SnakePos tryMoveCounterClockwise(SnakePos curr, int[][] grid) {
        if (curr.c1.r == curr.c2.r) {
            SnakePos next = new SnakePos(
                    new Cell(curr.c1.r, curr.c1.c),
                    new Cell(curr.c2.r - 1, curr.c2.c + 1)
            );
            if (valid(next.c2, grid)
                    && (valid(new Cell(curr.c1.r + 1, curr.c2.c + 1), grid))) {
                return next;
            }
        }
        return null;
    }

    private boolean valid(int r, int c, int[][] grid) {
        int n = grid.length;
        return (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 0);
    }

    private boolean valid(Cell cell, int[][] grid) {
        return valid(cell.r, cell.c, grid);
    }

    private boolean valid(SnakePos snakePos, int[][] grid) {
        return valid(snakePos.c1, grid) && valid(snakePos.c2, grid);
    }

    public class Cell {

        int r, c;

        public Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public String getPos() {
            return r + "," + c;
        }

        @Override public boolean equals(Object obj) {
            Cell cell = (Cell) obj;
            return r == cell.r && c == cell.c;
        }

    }

    public class SnakePos {
        Cell c1, c2;

        public SnakePos(Cell c1, Cell c2) {
            this.c1 = c1;
            this.c2 = c2;
        }

        public String getPos() {
            return c1.getPos() + ":" + c2.getPos();
        }

        @Override public boolean equals(Object obj) {
            SnakePos snakePos = (SnakePos) obj;
            return snakePos.c1.equals(c1) && snakePos.c2.equals(c2);
        }

    }
}
