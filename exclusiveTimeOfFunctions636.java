import java.util.List;
import java.util.Stack;

public class exclusiveTimeOfFunctions636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int preTime = 0;
        Stack<Integer> stack = new Stack<>();
        for (String log : logs) {
            String[] logSplit = log.split(":");
            int idx = Integer.parseInt(logSplit[0]);
            String symbol = logSplit[1];
            int timeStamp = Integer.parseInt(logSplit[2]);
            if (!stack.isEmpty()) {
                res[stack.peek()] += timeStamp - preTime;
            }
            preTime = timeStamp;
            if (symbol.equals("start")) stack.push(idx);
            else {
                int endIdx = stack.pop();
                ++res[endIdx];
                ++preTime;
            }
        }
        return res;
    }
}
