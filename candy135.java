import java.util.Arrays;

public class candy135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candyNum = new int[n];
        Arrays.fill(candyNum, 1);
        for (int i = 0; i < n - 1; ++i)
            if (ratings[i + 1] > ratings[i])
                candyNum[i + 1] = candyNum[i] + 1;
        for (int i = n - 1; i > 0; --i)
            if (ratings[i - 1] > ratings[i])
                candyNum[i - 1] = Math.max(candyNum[i - 1], candyNum[i] + 1);
        int res = 0;
        for (int candies : candyNum)
            res += candies;
        return res;
    }
}
