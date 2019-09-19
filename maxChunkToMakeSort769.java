public class maxChunkToMakeSort769 {
    public int maxChunksToSorted(int[] arr) {
        int res = 0, n = arr.length, mx = 0;
        for(int i = 0; i < n; ++i) {
            mx = Math.max(mx, arr[i]);
            if (mx == i) ++res;
        }
        return res;
    }
}
