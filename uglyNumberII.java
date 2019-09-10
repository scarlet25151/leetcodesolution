import java.util.ArrayList;
import java.util.List;

public class uglyNumberII {
    public int nthUglyNumber(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while (res.size() < n) {
            int m2 = res.get(i2) * 2;
            int m3 = res.get(i3) * 3;
            int m5 = res.get(i5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            if (min == m2) ++i2;
            if (min == m3) ++i3;
            if (min == m5) ++i5;
            res.add(min);
        }
        return res.get(res.size() - 1);
    }
}
