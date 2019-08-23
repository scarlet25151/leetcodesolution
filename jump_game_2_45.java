import java.util.*;

public class jump_game_2_45 {
    public static int jump(int[] nums) {
        int jump_num = 0;
        int cur = 0, pre, i = 0, n = nums.length;
        while (cur < n - 1) {
            ++jump_num;
            pre = cur;
            for (; i <= pre; ++i)
                cur = Math.max(cur, i + nums[i]);
            if (cur == pre) return -1;
        }
        return jump_num;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = scanner.nextInt();
        System.out.println(jump(arr));
    }
}
