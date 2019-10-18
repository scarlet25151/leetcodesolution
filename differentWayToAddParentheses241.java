import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class differentWayToAddParentheses241 {
    private Map<String, List<Integer>> memo = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if (memo.containsKey(input)) return memo.get(input);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        switch (input.charAt(i)) {
                            case '+' : res.add(left.get(j) + right.get(k)); break;
                            case '-' : res.add(left.get(j) - right.get(k)); break;
                            case '*' : res.add(left.get(j) * right.get(k)); break;
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) res.add(Integer.parseInt(input));
        memo.put(input, res);
        return res;
    }
}
