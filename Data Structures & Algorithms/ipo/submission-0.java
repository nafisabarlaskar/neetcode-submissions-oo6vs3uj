class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length, j = 0;
        List<int[]> projects = new ArrayList<>();
        for (int i = 0; i < n; i++){
            projects.add(new int[] {capital[i], profits[i]});
        }
        
        Collections.sort(projects, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k; i++){
            while (j < n && projects.get(j)[0] <= w){
                pq.offer(projects.get(j++)[1]);
            }

            if (pq.isEmpty()){
                break;
            }

            w += pq.poll();
        }

        return w;
    }
}