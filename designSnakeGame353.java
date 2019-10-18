import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class designSnakeGame353 {
    class SnakeGame {
        private int width, height, score;
        private Stack<int[]> food = new Stack<>();
        private Stack<int[]> snake = new Stack<>();

        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            for (int[] tmp : food) {
                this.food.push(tmp);
            }
            score = 0;
            snake.add(new int[] {0, 0});
        }

        public int move(String direction) {
            int[] head = snake.get(0), tail = snake.pop();
            if (direction.equals("U")) --head[0];
            else if (direction.equals("L")) --head[1];
            else if (direction.equals("R")) ++head[1];
            else if (direction.equals("D")) ++head[0];
            if (snake.contains(head) || head[0] < 0 || head[0] >= height
                    || head[1] < 0 || head[1] >= width) {
                return -1;
            }
            snake.add(0, head);
            if (!food.isEmpty() && head == food.get(0)) {
                food.remove(0);
                snake.add(tail);
                ++score;
            }
            return score;
        }

        private boolean contain(Stack<int[]> snake, int[] head) {
            for (int[] tmp : snake) {
                if (tmp == head) return true;
            }
            return false;
        }

    }
    public static void main(String[] args) {

    }
}
