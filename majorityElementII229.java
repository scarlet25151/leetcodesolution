import java.util.ArrayList;
import java.util.List;

public class majorityElementII229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int a = 0, b = 0, cnt1 = 0, cnt2 = 0, n = nums.length;
        for (int num : nums) {
            if (num == a) ++cnt1;
            else if (num == b) ++cnt2;
            else if (cnt1 == 0) {a = num; cnt1 = 1;}
            else if (cnt2 == 0) {b = num; cnt2 = 1;}
            else {cnt1--; cnt2--;}
        }
        cnt1 = cnt2 = 0;
        for (int num : nums) {
            if (num == a) ++cnt1;
            else if (num == b) ++ cnt2;
        }
        if (cnt1 > n / 3) res.add(a);
        if (cnt2 > n / 3) res.add(b);
        return res;
    }
}
