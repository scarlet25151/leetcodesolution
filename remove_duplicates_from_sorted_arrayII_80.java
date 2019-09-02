public class remove_duplicates_from_sorted_arrayII_80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[j] == nums[i]) {
                if (i == 0) {
                    i++;j++;
                } else if (nums[i] == nums[i - 1]) {
                    j++;
                } else {
                    i++;
                    nums[i] = nums[j];
                    j++;
                }
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;
    }
}
