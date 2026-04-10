class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));
        for (int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int num : count.keySet()){
            pq.offer(num);
            if (pq.size() > k){
                pq.poll();
            }
        }

        int i = 0, result[] = new int[pq.size()];
        while (!pq.isEmpty()){
            result[i++] = pq.poll();
        }

        return result;
    }
}
