import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class kthSmallestElementinSortedArray378 {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                queue.offer(matrix[i][j]);
                if (queue.size() > k) queue.poll();
            }
        }
        return queue.peek();
    }
    public int kthSmallest_BinarySearch(int[][] matrix, int k) {
        int left = matrix[0][0], right = matrix[matrix.length - 1][matrix[matrix.length - 1].length - 1];
        while (left < right) {
            int mid = (left + right) / 2;
            int cnt = searchLessEqual(matrix, mid);
            if (cnt < k) left = mid + 1;
            else right = mid;
        }
        return left;
    }
    private int searchLessEqual(int[][] matrix, int k) {
        int n = matrix.length, i = n - 1, j = 0, res = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= k) {
                res += i + 1;
                ++j;
            } else --i;
        }
        return res;
    }
}
