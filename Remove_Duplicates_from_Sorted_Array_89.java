import java.util.HashMap;

public class Remove_Duplicates_from_Sorted_Array_89 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        int res = 0, cur = 1, count = 1;
        while (res < n) {
            if (nums[res] == nums[cur] && count == 0) ++cur;
            else {
                if (nums[res] == nums[cur]) --count;
                else count = 1;
                nums[++res] = nums[cur++];
            }
        }
        return res + 1;
    }
}
