import java.util.Arrays;

public class taskScheduler621 {
    public static int leastInterval(char[] tasks, int n) {
        int mx = 0, mxCnt = 0;
        int[] cnt = new int[26];
        Arrays.fill(cnt, 0);
        for (char task : tasks) {
            ++cnt[task - 'A'];
            if (mx == cnt[task - 'A'])
                mxCnt++;
            else if (mx < cnt[task - 'A']) {
                mx = cnt[task - 'A'];
                mxCnt = 1;
            }
        }
        int partCnt = mx - 1;
        int partLen = n - (mxCnt - 1);
        int emptySlots = partCnt * partLen;
        int taskLeft = tasks.length - mx * mxCnt;
        int idles = Math.max(0, emptySlots - taskLeft);
        return tasks.length + idles;
    }
    public static void main(String[] args) {

    }
}
