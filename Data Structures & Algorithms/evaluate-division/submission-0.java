class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = queries.size(), j = 0;
        double[] result = new double[n];
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++){
            List<String> eq = equations.get(i);
            graph.computeIfAbsent(eq.get(0), k -> new HashMap()).put(eq.get(1), values[i]);
            graph.computeIfAbsent(eq.get(1), k -> new HashMap()).put(eq.get(0), 1/values[i]);
        }

        for (List<String> q : queries){
            String dividend = q.get(0), divisor = q.get(1);
            if (!graph.containsKey(dividend)|| !graph.containsKey(divisor)){
                result[j++] = -1.0;
            } else if (dividend.equals(divisor)){
                result[j++] = 1.0;
            } else {
                result[j++] = dfs(graph, dividend, divisor, 1.0, new HashSet<>());
            }
        }

        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String source, String target, Double product, Set<String> visited){
        double result = -1.0;
        visited.add(source);
        Map<String, Double> neighbors = graph.get(source);
        if (neighbors.containsKey(target)){
            result = product * neighbors.get(target);
        } else {
            for (var neighbor : neighbors.entrySet()){
                if (!visited.contains(neighbor.getKey())){
                    result = dfs(graph, neighbor.getKey(), target, product * neighbor.getValue(), visited);
                    if (result != -1.0){
                        break;
                    }
                }
            }
        }
        
        visited.remove(source);
        return result;
    }
}