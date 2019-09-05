import javafx.util.Pair;

import java.util.*;

public class evaluate_division_399 {
    private static HashMap<String, HashMap<String, Double>> dividedMap = new HashMap<>();

    // DFS_method
    private static double[] calcEquation_dfs(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries) {
        double[] res = new double[queries.size()];
        int idx = 0;
        for (List<String> equation : equations) {
            if (dividedMap.containsKey(equation.get(0))) {
                HashMap<String, Double> readDenominator = dividedMap.get(equation.get(0));
                readDenominator.put(equation.get(1), values[idx]);
                dividedMap.replace(equation.get(0), readDenominator);
            } else {
                HashMap<String, Double> readDenominator = new HashMap<>();
                readDenominator.put(equation.get(1), values[idx]);
                dividedMap.put(equation.get(0), readDenominator);
            }

            if (dividedMap.containsKey(equation.get(1))) {
                HashMap<String, Double> readNumerator = dividedMap.get(equation.get(1));
                readNumerator.put(equation.get(0), 1.0 / values[idx]);
                dividedMap.replace(equation.get(1), readNumerator);
            } else {
                HashMap<String, Double> readNumerator = new HashMap<>();
                readNumerator.put(equation.get(0), 1.0 / values[idx]);
                dividedMap.put(equation.get(1), readNumerator);
            }
            idx++;
        }
        idx = 0;
        for (List<String> query : queries) {
            Set<String> isVisited = new HashSet<>();
            double calRes = dfs(query.get(0), query.get(1), isVisited);
            res[idx++] = (calRes > 0.0) ? calRes : -1;
        }
        return res;
    }
    private static double dfs(String numerator, String denominator, Set<String> isVisited) {
        if (dividedMap.containsKey(numerator)) {
            if (dividedMap.get(numerator).containsKey(denominator))
                return dividedMap.get(numerator).get(denominator);
            HashMap<String, Double> denominatorMap = dividedMap.get(numerator);
            for (String newNumerator : denominatorMap.keySet()) {
                if (isVisited.contains(newNumerator)) continue;
                isVisited.add(newNumerator);
                double t = dfs(newNumerator, denominator, isVisited);
                if (t > 0.0) return t * denominatorMap.get(newNumerator);
            }
        }
        return -1.0;
    }

    // BFS_Method
    private static double[] calcEquation_bfs(List<List<String>> equations,
                                             double[] values,
                                             List<List<String>> queries) {
        double[] res = new double[queries.size()];
        // Generate the paths
        int idx = 0;
        for (List<String> equation : equations) {
            if (dividedMap.containsKey(equation.get(0))) {
                HashMap<String, Double> readDenominator = dividedMap.get(equation.get(0));
                readDenominator.put(equation.get(1), values[idx]);
                readDenominator.put(equation.get(0), 1.0);
                dividedMap.replace(equation.get(0), readDenominator);
            } else {
                HashMap<String, Double> readDenominator = new HashMap<>();
                readDenominator.put(equation.get(1), values[idx]);
                readDenominator.put(equation.get(0), 1.0);
                dividedMap.put(equation.get(0), readDenominator);
            }

            if (dividedMap.containsKey(equation.get(1))) {
                HashMap<String, Double> readNumerator = dividedMap.get(equation.get(1));
                readNumerator.put(equation.get(0), 1.0 / values[idx]);
                readNumerator.put(equation.get(1), 1.0);
                dividedMap.replace(equation.get(1), readNumerator);
            } else {
                HashMap<String, Double> readNumerator = new HashMap<>();
                readNumerator.put(equation.get(0), 1.0 / values[idx]);
                readNumerator.put(equation.get(1), 1.0);
                dividedMap.put(equation.get(1), readNumerator);
            }
            idx++;
        }
        idx = 0;
        for (List<String> query : queries) {
            if (!dividedMap.containsKey(query.get(0)) ||
                    !dividedMap.containsKey(query.get(1))) {
                res[idx++] = -1.0;
                continue;
            }
            Queue<Pair<String, Double>> queue = new ArrayDeque<>();
            Set<String> isVisited = new HashSet<>();
            isVisited.add(query.get(0));
            boolean found = false;
            queue.add(new Pair(query.get(0), 1.0));
            while (!queue.isEmpty() && !found) {
                for (int i = queue.size(); i > 0; --i) {
                    Pair<String, Double> denominatorVal = queue.poll();
                    if (denominatorVal.getKey().equals(query.get(1))) {
                        found = true;
                        res[idx++] = denominatorVal.getValue();
                        break;
                    }
                    HashMap<String, Double> denominatorMap = dividedMap.get(denominatorVal.getKey());
                    for (String newNumerator : denominatorMap.keySet()) {
                        if (isVisited.contains(newNumerator)) continue;
                        isVisited.add(newNumerator);
                        queue.add(new Pair(newNumerator,
                                denominatorMap.get(newNumerator) * denominatorVal.getValue()));
                    }
                }
            }
            if (!found) res[idx++] = -1.0;
        }
        return res;
    }


    public static void main(String[] args) {
        // Test case;
        String[][] testInput1 = {{"a", "b"}, {"b", "c"}};
        List<List<String>> equations = new ArrayList<>();
        for (String[] s : testInput1) {
            equations.add(Arrays.asList(s));
        }
        double[] values = {2.0, 3.0};
        String[][] testInput2 = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        List<List<String>> queries = new ArrayList<>();
        for (String[] s : testInput2)
            queries.add(Arrays.asList(s));
        double[] output = calcEquation_dfs(equations, values, queries);
    }


}
