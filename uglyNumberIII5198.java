import java.util.ArrayList;
import java.util.List;

public class uglyNumberIII5198 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long low = 1, high = Long.MAX_VALUE;
        long la = (long) a, lb = (long) b, lc = (long) c;
        long ab = la * lb / gcd(la, lb);
        long bc = lb * lc / gcd(lb, lc);
        long ac = la * lc / gcd(la, lc);
        long abc = la * bc / gcd(la, bc);
        while (low < high) {
            long mid = (low + high) / 2;
            long cnt = mid / la + mid / lb + mid / lc
                    - mid / ab - mid / ac - mid / bc + mid / abc;
            if (cnt < n)
                low = mid + 1;
            else high = mid;
        }
        return (int) low;
    }
    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
