import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class kthLargestElementinArray_215 {
    public int findKthLargest_sorting(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    public int findKthLargest_heap(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int val : nums) {
            queue.add(val);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
    public int findKthLarges_quickselect(int[] nums, int k) {
        k = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int  j = partition(nums, left, right);
            if (j == k) {
                break;
            } else if (j < k) {
                left = j + 1;
            } else {
                right = j - 1;
            }
        }
        return nums[k];
    }
    private int partition(int[] nums, int left, int right) {
        int i = left, j = right + 1;
        while (true) {
            while (nums[++i] < nums[left] && i < right) ;
            while (nums[--j] > nums[left] && j > left) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
