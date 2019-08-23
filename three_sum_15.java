import java.util.*;


public class three_sum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<Integer> num_set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            num_set.clear();
            for (int j = 0; j < nums.length; j++) {
                int x = - (nums[i] + nums[j]);
                if (num_set.contains(x)) {
                    List<Integer> temp_res = new ArrayList<>();
                    temp_res.add(x);
                    temp_res.add(nums[i]);
                    temp_res.add(nums[j]);
                    res.add(temp_res);
                }
                else
                    num_set.add(nums[j]);
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int x = - nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] > x)
                    right--;
                else if (nums[left] + nums[right] < x)
                    left++;
                else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++; right--;
                    while (left < nums.length && nums[left] == nums[left - 1])
                        left++;
                    while (right >=0 && nums[right] == nums[right + 1])
                        right--;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1])
                i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrayLen = scanner.nextInt();
        int[] nums = new int[arrayLen];
        for (int i = 0; i < arrayLen; i ++)
            nums[i] = scanner.nextInt();

        List<List<Integer>> res = new ArrayList<>();

    }

}
