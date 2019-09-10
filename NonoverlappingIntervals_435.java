import java.util.Arrays;
import java.util.Comparator;

public class NonoverlappingIntervals_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int cnt = 1, end  = intervals[0][1];
        for (int[] interval : intervals) {
            // facing the overlapping interval, drop it.
            if (interval[0] < end) {
                continue;
            }
            end = interval[1];
            cnt++;
        }
        return intervals.length - cnt;

    }
}
