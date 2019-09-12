public class GasStation134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, curGas = 0;
        int startStation = 0;
        int n = gas.length;
        for (int i = 0; i < n; ++i) {
            totalGas += gas[i] - cost[i];
            curGas += gas[i] - cost[i];
            if (curGas < 0) {
                curGas = 0;
                startStation = i + 1;
            }
        }
        return totalGas >= 0 ? startStation : -1;
    }
}
