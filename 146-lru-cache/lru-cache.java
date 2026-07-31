class Node {
    Node prev;
    Node next;
    int val;
    int key;
    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {
    int capacity;
    Node head = null;
    Node tail = null;
    HashMap<Integer, Node> map = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        makeRecentlyUsed(key);
        return map.get(key).val;

    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node curr = map.get(key);
            curr.val = value;
            makeRecentlyUsed(key);
            return;
        }
        if(map.size() == capacity) {
            map.remove(tail.key);
            if(head == tail) {
                head = null;
                tail = null;
            }
            else {
                tail = tail.prev;
                tail.next = null;
            }
        }

        Node newNode = new Node(key, value);
        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        map.put(key, newNode);
    }
    public void makeRecentlyUsed(int key) {
        Node curr = map.get(key);

        if(curr == head) return;
        Node prev = curr.prev;
        Node next = curr.next;
        if(prev != null) prev.next = next;
        if(next != null) next.prev = prev;

        if(curr == tail) {
            tail = curr.prev;
        }
        curr.next = head;
        head.prev = curr;
        curr.prev = null;
        head = curr;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */