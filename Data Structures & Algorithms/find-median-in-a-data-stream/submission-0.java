class MedianFinder {
    PriorityQueue<Integer> max, min;
    public MedianFinder() {
        max = new PriorityQueue<>((a, b) -> b - a);
        min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (min.size() > max.size()){
            max.offer(min.poll());
        }
    }
    
    public double findMedian() {
        if (min.size() == max.size()){
            return (min.peek() + max.peek())/2.0;
        }

        return max.peek();
    }
}
