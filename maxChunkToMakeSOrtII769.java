import java.util.Arrays;

public class maxChunkToMakeSOrtII769 {
    public int maxChunksToSorted(int[] arr) {
        long res = 0, sum1 = 0, sum2 = 0;
        int n = arr.length;
        int[] expect;
        expect = Arrays.copyOf(arr, n);
        Arrays.sort(expect);
        for (int i = 0; i < n; i++) {
            sum1 += expect[i];
            sum2 += arr[i];
            if (sum1 == sum2) res++;
        }
        return (int) res;
    }
}
