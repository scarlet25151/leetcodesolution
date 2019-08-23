import java.util.Scanner;

public class search_insert_position_35 {
    public static int searchInsert(int[] nums, int target) {
        int pivot = 0;
        while (pivot < nums.length && nums[pivot] <= target)
            pivot++;
        return pivot;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i)
            nums[i] = scanner.nextInt();
        int target = scanner.nextInt();
        System.out.println(searchInsert(nums, target));
    }
}
