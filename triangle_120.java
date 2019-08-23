import java.util.*;
public class triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); ++i) {
            for (int j = 0; j < triangle.get(i).size(); ++j) {
                if (j == 0) {
                    triangle.get(i).set(j,
                            triangle.get(i).get(j) + triangle.get(i - 1).get(j));
                } else if (j == triangle.get(i).size() - 1) {
                    triangle.get(i).set(j,
                            triangle.get(i).get(j) + triangle.get(i - 1).get(j - 1));
                } else {
                    triangle.get(i).set(j, triangle.get(i).get(j) +
                            Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)));
                }
            }
        }
        int res = Integer.MAX_VALUE;
        List<Integer> lastLine = triangle.get(triangle.size() - 1);
        if (lastLine.isEmpty()) return 0;
        for (int num : lastLine) {
            if (num < res) res = num;
        }
//        Iterator<Integer> it = lastLine.iterator();
//        while(it.hasNext()) {
//            res = (it.next() < res) ? it.next() : res;
//        }
        return res;
    }

    public int minimumTotal_solution2(List<List<Integer>> triangle) {
        List<Integer> dp = triangle.get(triangle.size() - 1);
        for (int i = triangle.size() - 2; i >= 0; --i) {
            for (int j = 0; j <= i; ++j) {
                dp.set(j, triangle.get(i).get(j) +
                        Math.min(dp.get(j), dp.get(j + 1)));
            }
        }
        return dp.get(0);
    }
}