package local.leetcode;

import java.util.*;

public class EvaluateDivision_399 {
    Map<String, Map<String, Double>> graph = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build the graph
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, val);
            graph.get(b).put(a, 1.0 / val);
        }

        // Process each query
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            Set<String> visited = new HashSet<>();
            results[i] = dfs(src, dest, 1.0, visited);
        }

        return results;
    }

    private double dfs(String current, String target, double accProduct, Set<String> visited) {
        if (!graph.containsKey(current) || !graph.containsKey(target)) return -1.0;
        if (current.equals(target)) return accProduct;

        visited.add(current);

        for (Map.Entry<String, Double> neighbor : graph.get(current).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double result = dfs(neighbor.getKey(), target, accProduct * neighbor.getValue(), visited);
                if (result != -1.0) return result;
            }
        }

        return -1.0;
    }

}
