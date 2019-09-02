import javafx.util.Pair;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class product_of_array_except_self_238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int res[] = new int[n], fwd[] = new int[n], bwd[] =new int[n];
        fwd[0] = 1;bwd[n - 1] = 1;
        for (int i = 1; i < n; ++i) {
            int j = n - i - 1;
            fwd[i] = fwd[i - 1] * nums[i - 1];
            bwd[j] = bwd[j + 1] * nums[j + 1];
        }
        for (int i = 0; i < n; ++i)
            res[i] = fwd[i] * bwd[i];

        return res;
    }
}
