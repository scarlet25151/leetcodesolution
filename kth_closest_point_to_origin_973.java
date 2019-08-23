import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class kth_closest_point_to_origin_973 {
    public int[][] kClosest_solu1(int[][] points, int K) {
        int pnum = points.length;
        int[] dists = new int[pnum];
        for (int i = 0; i < pnum; ++i)
            dists[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
        Arrays.sort(dists);
        int K_rank = dists[K - 1];
        int[][] res = new int[K][2];
        int t = 0;
        for (int i = 0; i < pnum; ++i) {
            if (points[i][0] * points[i][0] + points[i][1] * points[i][1] <= K_rank)
                res[t++] = points[i];
        }
        return res;
    }
    //solution2
    int[][] points;
    public int[][] kCloset(int[][] points, int K) {
        this.points = points;
        sort(0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }
    public void sort(int i, int j, int K) {
        if (i >= j) return;
        int k = ThreadLocalRandom.current().nextInt(i, j);
        swap(i, k);
        int mid = partition(i, j);
        int leftLength = mid - i + 1;
        if (K < leftLength)
            sort(i, mid - 1, K);
        else if (K > leftLength)
            sort(mid + 1, j, K - leftLength);
    }

    public int partition(int i, int j) {
        int oi = i;
        int pivot = dist(i);
        i++;
        while(true) {
            while (i < j && dist(i) < pivot) ++i;
            while (i <= j && dist(j) > pivot) --j;
            if (i >= j) break;
            swap(i, j);
        }
        swap(oi, j);
        return j;
    }

    public int dist(int i) {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }

    public void swap(int i, int j) {
        int t0 = points[i][0], t1 = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = t0;
        points[j][1] = t1;
    }
}
