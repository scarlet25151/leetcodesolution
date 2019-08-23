import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Insert_Interval_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> res = new ArrayList<>();
        int n = intervals.length, cur = 0;
        List<Integer> ans = new ArrayList<>();
        while (cur < n && intervals[cur][1] < newInterval[0]) {
            ans.add(intervals[cur][0]);
            ans.add(intervals[cur][1]);
            res.add(ans);
            ans.clear();
            cur++;
        }
        while (cur < n && intervals[cur][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[cur][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[cur][1]);
            ++cur;
        }
        ans.add(intervals[cur][0]);
        ans.add(intervals[cur][1]);
        res.add(ans);
        ans.clear();
        while (cur < n) {
            ans.add(intervals[cur][0]);
            ans.add(intervals[cur][1]);
            res.add(ans);
            ans.clear();
            cur++;
        }
        return (int[][]) res.toArray();
    }
}
