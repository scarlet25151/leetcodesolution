import java.util.Arrays;

public class sumOfSubsequenceWidths891 {
    public int sumSubseqWidths(int[] A) {
        long res = 0, n = A.length, M = 1000000007, c = 1;
        int leftSum = 0, rightSum = 0, left = 0, right = (int) n - 1;
        Arrays.sort(A);
        while (left < n) {
            leftSum += A[left++];
            rightSum += A[right--];
            res = (res + (rightSum - leftSum) * c) % M;
            c = (c << 1) % M;
        }
        return (int) res;
    }
}
