import java.util.Arrays;
import java.util.Comparator;

public class minimumNumberofArrowstoBustBalloons_452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
            }
        });
        int res = 1, end = points[0][1];
        for (int[] point : points) {
            if (point[0] <= end) {
                end = Math.min(end, point[1]);
            } else {
                res ++;
                end = point[1];
            }
        }
        return res;
    }
}
