class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets){
            graph.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));
        }

        graph.forEach((k, v) -> Collections.sort(v));
        List<String> result = new ArrayList<>();
        dfs(graph, result, "JFK");
        return result;
    }

    private void dfs(Map<String, List<String>> graph, List<String> result, String source) {
        if (graph.containsKey(source)) {
            List<String> list = graph.get(source);
            while (list.size() > 0){
                dfs(graph, result, list.removeFirst());
            }
        }

        result.addFirst(source);
    }
}
