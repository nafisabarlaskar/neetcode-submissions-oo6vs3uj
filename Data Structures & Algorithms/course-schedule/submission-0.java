class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        for (int i = 0; i < indegree.length; i++){
            if (indegree[i] == 0){
                q.offer(i);
            }
        }

        while (!q.isEmpty()){
            int node = q.poll();
            count++;
            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        return numCourses == count;
    }
}
