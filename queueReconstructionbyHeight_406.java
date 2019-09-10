import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class queueReconstructionbyHeight_406 {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0)
            return new int[0][0];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int[][] res = new int[people.length][2];
        for (int[] p :people) {
            res[p[1]][0] = p[0];
            res[p[1]][1] = p[1];
        }
        return res;
    }
}
