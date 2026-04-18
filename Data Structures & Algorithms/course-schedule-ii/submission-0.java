class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int indegree[] = new int[numCourses], result[] = new int[numCourses], j = 0;
        for (int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                q.offer(i);
            }
        }


        while (q.size() > 0){
            int node = q.poll();
            result[j++] = node;
            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        return j == numCourses ? result : new int[0];
    }
}
