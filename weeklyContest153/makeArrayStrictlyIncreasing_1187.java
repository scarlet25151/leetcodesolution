package weeklyContest153;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class makeArrayStrictlyIncreasing_1187 {
    public static int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int[] dp = new int[arr1.length];
        //dp[i] denote
        dp[0] = 0;
        Arrays.sort(arr2);

        for (int i = 1; i < arr1.length; ++i) {
            if (arr1[i] <= arr1[i - 1]) {
                int j = arr2.length - 1;
                for(; j >= 0; --j)
                    if (arr2[j] <= arr1[i]) break;
                if (arr2[++j] >= arr1[i]) return -1;
                arr1[i - 1] = arr2[j];
                dp[i] = dp[i - 1] + 1;
            }
            else dp[i] = dp[i - 1];
        }
        return dp[arr1.length - 1];
    }
    
    public static void main(String[] args) {
        int[] arr1 = {1,5,3,6,7}, arr2 = {1,3,2,4};
        System.out.println(makeArrayIncreasing(arr1, arr2));
    }
}
