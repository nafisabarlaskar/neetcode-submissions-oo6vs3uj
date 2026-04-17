class LRUCache {
    Node head = null, end = null;
    Map<Integer, Node> map;
    int size;
    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
            setHead(node);
            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            setHead(node);
        } else {
            Node node = new Node(key, value);
            if (map.size() >= size){
                map.remove(end.key);
                removeNode(end);
            }

            setHead(node);
            map.put(key, node);
        }
    }

    private void setHead(Node node){
        node.next = head;
        node.pre = null;
        if (head != null){
            head.pre = node;
        }

        head = node;
        if (end == null){
            end = head;
        }
    }

    private void removeNode(Node node){
        if (node.pre != null){
            node.pre.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null){
            node.next.pre = node.pre;
        } else {
            end = node.pre;
        }
    }
}
class Node {
    int key;
    int val;
    Node next;
    Node pre;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}
