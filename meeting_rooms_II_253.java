import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class meeting_rooms_II_253 {
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length],
                ends = new int[intervals.length];
        int res = 0, endPos = 0,idx = 0;
        for (int[] interval : intervals) {
            starts[idx] = interval[0];
            ends[idx] = interval[1];
            idx ++;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        for (int i = 0; i < intervals.length; ++i) {
            if (starts[i] < ends[endPos]) ++res;
            else endPos++;
        }
        return res;
    }

    public int minMeetingRooms_minHeap(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Queue<Integer> Q = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!Q.isEmpty() && Q.peek() <= interval[0]) Q.poll();
            Q.add(interval[1]);
        }
        return Q.size();
    }
}
