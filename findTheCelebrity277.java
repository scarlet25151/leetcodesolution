public class findTheCelebrity277 {
    public boolean knows(int a, int b) {
        return (a == b);
    }
    public int findCelebrity(int n) {
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (knows(res, i)) res = i;
        }
        for (int i = 0; i < res; ++i) {
            if (knows(res, i) || !knows(i, res)) return -1;
        }
        for (int i = res + 1; i < n; i++) {
            if (!knows(i, res)) return -1;
        }
        return res;

    }
}
