import java.util.HashMap;
import java.util.Map;

public class fourSumII454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        if (n == 0) return 0;
        HashMap<Integer, Integer> sums1 = new HashMap<>();
        HashMap<Integer, Integer> sums2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum1 = A[i] + B[j];
                int sum2 = C[i] + D[j];

                sums1.put(sum1, sums1.getOrDefault(sum1, 0) + 1);
                sums2.put(sum2, sums2.getOrDefault(sum2, 0) + 1);
            }

        }

        int res = 0;

        for (Map.Entry<Integer, Integer> entry : sums1.entrySet()) {
            res += entry.getValue() * sums2.getOrDefault(- entry.getKey(), 0);
        }
        return res;
    }
}
