import java.util.Scanner;
import java.util.Stack;

public class Largest_rectangle_in_histogram {
    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        int n_heights[] = new int[heights.length + 1];
        for (int k = 0; k < heights.length; ++k)
            n_heights[k] = heights[k];
        n_heights[heights.length] = 0;
        Stack<Integer> increase_st = new Stack<>();
        for (int i = 0; i < n_heights.length; ++i) {
            if (increase_st.isEmpty() || n_heights[increase_st.peek()] < n_heights[i])
                increase_st.push(i);
            else {
                int cur = increase_st.peek(); increase_st.pop();
                res = Math.max(res, n_heights[cur] * (increase_st.isEmpty() ? i : i - increase_st.peek() - 1));
                --i;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int histogram[] = new int[n];
        for (int i = 0; i < n; i++) {
            histogram[i] = scanner.nextInt();
        }
        System.out.println(largestRectangleArea(histogram));
    }
}
