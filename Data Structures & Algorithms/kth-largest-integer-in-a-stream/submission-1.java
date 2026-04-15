class KthLargest {
    int size;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        size = k;
        pq = new PriorityQueue<>();
        for (int num : nums){
            pq.offer(num);
            if (pq.size() > k){
                pq.poll();
            }
        }

    }
    
    public int add(int val) {
        pq.offer(val);
        if (pq.size() > size){
            pq.poll();
        }

        return pq.peek();
    }
}
