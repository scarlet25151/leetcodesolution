import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class listMax {

    public static long[] create(int n) {
        int size = 1;
        while (n >= size) {
            size <<= 1;
        }
        return new long[size];
    }
    public static void range_add(long[] fwam, long[] fwaa, int low, int high, long val) {
        update(fwam, fwaa, low, val, -val * (low - 1));
        update(fwam, fwaa, high, -val, val * high);
    }

    public static void update(long[] fwam, long[] fwaa, int at, long m, long a){
        int s = fwam.length;
        while (at < s) {
            fwam[at] += m;
            fwaa[at] += a;
            at += at & (-at);
        }
    }

    public static long range_query(long[] fwam, long[] fwaa, int at) {
        long m = 0;
        long a = 0;
        long st = at;
        while (at > 0) {
            m += fwam[at];
            a += fwaa[at];
            at -= at & (-at);
        }
        return m * st + a;
    }
    public static long listMax(int n, List<List<Integer>> operations) {
        // Write your code here
        long[] fwam = create(n);
        long[] fwaa = create(n);
        for (List<Integer> op : operations) {
            int a = op.get(0);
            int b = op.get(1);
            long k = op.get(2);
            range_add(fwam, fwaa, a, b, k);
        }
        long best = 0;
        long prev = 0;
        for (int i = 1; i < n + 1; i++) {
            long cur = range_query(fwam, fwaa, i);
            best = Math.max(best, cur - prev);
            prev = cur;
        }
        return best;
    }
}
