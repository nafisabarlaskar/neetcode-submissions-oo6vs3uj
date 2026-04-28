class MyCircularQueue {
    int n, head, count, queue[];
    public MyCircularQueue(int k) {
        this.n = k;
        this.queue = new int[k];
        head = 0;
        count = 0;
    }
    
    public boolean enQueue(int value) {
        if (count == n){
            return false;
        }

        queue[(head + count) % n] = value;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if (count == 0){
            return false;
        }

        head = (head + 1) % n;
        count--;
        return true;
    }
    
    public int Front() {
        if (count == 0){
            return -1;
        }

        return queue[head];
    }
    
    public int Rear() {
        if (count == 0){
            return -1;
        }

        return queue[(head + count - 1) % n];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == n;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */