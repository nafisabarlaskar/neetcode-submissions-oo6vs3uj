class MyHashMap {
    private int keySpace;
    private List<Bucket> hashTable;

    public MyHashMap() {
        this.keySpace = 2069;
        this.hashTable = new ArrayList<>();
        for (int i = 0; i < this.keySpace; i++){
            this.hashTable.add(new Bucket());
        }
    }
    
    public void put(int key, int value) {
        int hashKey = key % this.keySpace;
        this.hashTable.get(hashKey).update(key, value);
    }
    
    public int get(int key) {
        int hashKey = key % this.keySpace;
        return this.hashTable.get(hashKey).get(key);
    }
    
    public void remove(int key) {
        int hashKey = key % this.keySpace;
        this.hashTable.get(hashKey).remove(key);
    }
}

class Bucket {
    private List<int[]> bucket;

    public Bucket(){
        this.bucket = new ArrayList<>();
    }

    public Integer get(Integer key){
        for (int[] pair : bucket){
            if (pair[0] == key){
                return pair[1];
            }
        }

        return -1;
    }

    public void update(Integer key, Integer value){
        for (int[] pair : bucket){
            if (pair[0] == key){
                pair[1] = value;
                return;
            }
        }

        bucket.add(new int[]{key, value});
    }

    public void remove(Integer key){
        for (int[] pair : bucket){
            if (pair[0] == key){
                bucket.remove(pair);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */