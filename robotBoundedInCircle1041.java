public class robotBoundedInCircle1041 {
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            for (char instruction : instructions.toCharArray()) {
                switch (instruction) {
                    case 'G': {
                        x += dirs[idx][0];
                        y += dirs[idx][1];
                        break;
                    }
                    case 'R': {
                        idx ++;
                        if (idx >= 4) {
                            idx = 0;
                        }
                        break;
                    }
                    case 'L': {
                        idx--;
                        if (idx < 0) {
                            idx = 3;
                        }
                        break;
                    }
                }
            }
        }
        return x == 0 && y == 0;
    }
    public static void main(String[] args) {
        robotBoundedInCircle1041 solution = new robotBoundedInCircle1041();
        String instructions = "GG";
        System.out.print(solution.isRobotBounded(instructions));

    }
}
