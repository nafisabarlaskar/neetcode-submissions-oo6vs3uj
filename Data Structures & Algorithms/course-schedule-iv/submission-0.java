class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites){
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>())
                .add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }

        Map<Integer, Set<Integer>> prereq = new HashMap<>();
        while (!queue.isEmpty()){
            int node = queue.poll();
            for (int g : graph.getOrDefault(node, new ArrayList<>())){
                prereq.computeIfAbsent(g, k -> new HashSet<>()).add(node);
                for (int p : prereq.getOrDefault(node, new HashSet<>())){
                    prereq.get(g).add(p);
                }

                indegree[g]--;
                if (indegree[g] == 0){
                    queue.offer(g);
                }
            }
        }
        
        for (int[] q : queries){
            result.add(prereq.getOrDefault(q[1], new HashSet<>()).contains(q[0]));
        }

        return result;
    }
}

