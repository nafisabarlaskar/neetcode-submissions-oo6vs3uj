class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)-> (b - a));
        int[][] result = new int[k][2];
        for (int i = 0; i < n; i++){
            q.offer(distance(points[i]));
            if (q.size() > k){
                q.poll();
            }
        }

        int minDist = q.poll(), j = 0;
        for (int i = 0; i < n; i++){
            if (j == k){
                break;
            }

            if (distance(points[i]) <= minDist){
                result[j++] = points[i];
            }
        }

        return result;
    }

    private int distance(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}
