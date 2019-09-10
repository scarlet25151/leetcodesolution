public class remove_duplicated_from_sorted_array_26 {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int j = 1; j < nums.length; ++j) {
            if (nums[idx] != nums[j])
                nums[++idx] = nums[j];
        }
        return idx + 1;
    }
}
