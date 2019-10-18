import java.lang.reflect.Array;
import java.util.*;

public class minimumAbsoluteDifference5197 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Integer[] arrs = new Integer[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            arrs[i] = arr[i];
        }
        Arrays.sort(arrs, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        List<List<Integer>> res = new ArrayList<>();
        int min = Math.abs(arrs[1] - arrs[0]);
        for (int i = 1; i < arrs.length; i++) {
            if (Math.abs(arrs[1] - arrs[0]) == min) {
                res.add(Arrays.asList(arrs[i - 1], arrs[i]));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        minimumAbsoluteDifference5197 solution = new minimumAbsoluteDifference5197();

        int[] arr = {3,8,-10,23,19,-4,-14,27};
        List<List<Integer>> res = solution.minimumAbsDifference(arr);
    }
}
