import java.util.*;

public class longestAritmeticSubsequenceOfGivenDifference1218 {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int max = 0;
        for(int i=0;i<arr.length;i++){
            int count = hm.getOrDefault(arr[i],0) +1;
            if(count>max) max = count;
            hm.put(arr[i]+difference,count);                  //put the next expected number as key
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int difference = 1;
        longestAritmeticSubsequenceOfGivenDifference1218 solu = new longestAritmeticSubsequenceOfGivenDifference1218();
        int res = solu.longestSubsequence(arr, difference);

    }
}
