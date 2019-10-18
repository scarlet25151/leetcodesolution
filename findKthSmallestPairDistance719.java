import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class findKthSmallestPairDistance719 {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return -1;
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                queue.offer(Math.abs(nums[i] - nums[j]));
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }
    public int smallestDistancePair2(int[] nums, int k) {
        Arrays.sort(nums);
        int WIDTH = 2 * nums[nums.length - 1];
        int[] multiplicity = new int[nums.length];
        // 计算重复项
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                multiplicity[i] = 1 + multiplicity[i - 1];
            }
        }
        // prefix[v] = number of values <=v
        int[] prefix = new int[WIDTH];
        int left = 0;
        for (int i = 0; i < WIDTH; i++) {
            while(left < nums.length && nums[left] == i) {
                left++;
            }
            prefix[i] = left;
        }
        int lo = 0, hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                count += prefix[nums[i] +mid] - prefix[nums[i]] + multiplicity[i];
            }
            if (count >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    public int smallestDistancePair3(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int count = 0, left = 0;
            for (int right = 0; right < nums.length; right++) {
                while (nums[right] - nums[left] > mid) left++;
                count += right - left;
            }
            if (count >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
