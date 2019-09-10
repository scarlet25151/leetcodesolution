import java.util.Arrays;

public class bestTimetoBuyandSellStock {
    public int maxProfit_I(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
    public int maxProfit_II(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }
    public int maxProfit_III(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int[][] globalProfit = new int[n][3], localProfit = new int[n][3];


        // 局部最优值是比较前一天并少交易一次的全局最优加上大于0的差值，
        // 和前一天的局部最优加上差值中取较大值;
        // 而全局最优比较局部最优和前一天的全局最优
        for (int i = 1; i < prices.length; ++i) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= 2; ++j) {
                localProfit[i][j] = Math.max(globalProfit[i - 1][j - 1] + (diff > 0 ? diff : 0),
                        localProfit[i - 1][j] + diff);
                globalProfit[i][j] = Math.max(localProfit[i][j], globalProfit[i - 1][j]);
            }
        }
        return globalProfit[n - 1][2];
    }
    public int maxProfit_IV(int k, int[] prices) {
        // 1-D array
        if (prices.length == 0) return 0;
        if (k >= prices.length) return maxProfit_II(prices);
        int[] globalProfit = new int[k + 1];
        int[] localProfit = new int[k  + 1];
        Arrays.fill(globalProfit, 0);Arrays.fill(localProfit, 0);
        for (int i = 0; i < prices.length - 1; ++i) {
            int diff = prices[i + 1] - prices[i];
            for (int j = k; j>=1; --j) {
                localProfit[j] = Math.max(globalProfit[j - 1] + (diff > 0 ? diff : 0),
                        localProfit[j] + diff);
                globalProfit[j] = Math.max(localProfit[j], globalProfit[j]);
            }
        }
        return globalProfit[k];
    }

}
