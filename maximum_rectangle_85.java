import java.util.*;

public class maximum_rectangle_85 {

    public static int largestRectangleArea(int[] height) {
        int res = 0, n = height.length;
        int n_height[] = new int[n + 1];
        for (int k = 0; k < height.length; ++k)
            n_height[k] = height[k];
        n_height[n] = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n_height.length; ++i) {
            if (st.isEmpty() || n_height[st.peek()] < n_height[i])
                st.push(i);
            else {
                int cur = st.peek(); st.pop();
                res = Math.max(res, n_height[cur]);
                --i;
            }
        }
        return res;
    }
    //solution 1
    public int maximalRectangle1(char[][] matrix) {
        int res = 0;
        int height[];

        for (int i = 0; i < matrix.length; ++i) {
            height = new int[matrix[i].length];
            for (int j = 0; j < matrix.length; ++j)
                height[j] = matrix[i][j] == '0' ? 0 : (height[j] + 1);
            res = Math.max(res, largestRectangleArea(height));
        }
        return res;
    }

    //solution2
    public int maxmalRectangle(char[][] matrix) {
        int res = 0, h = matrix.length, w = matrix.length;
        int h_max[][] = new int[h][w];
        // 除去全0行外，统计当前位置的1含行最大宽度
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                if (matrix[i][j] == '0') continue;
                h_max[i][j] = j > 0 ? (h_max[i][j - 1] + 1) : 1;
            }
        }
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; j++) {
                if (h_max[i][j] == 0) continue;
                int loc = h_max[i][j];
                res = Math.max(res, loc);
                for (int k = i - 1; k >=0 && h_max[k][j] != 0; --k) {
                    loc = Math.min(loc, h_max[k][j]);
                    res = Math.max(res, loc * (i - k + 1));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
}
