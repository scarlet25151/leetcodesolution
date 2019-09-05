public class twoSumII_167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                int[] res = {left, right};
                return res;
            }
            else if (sum > target) right--;
            else if (sum < target) left ++;
        }
        return new int[2];
    }
}
