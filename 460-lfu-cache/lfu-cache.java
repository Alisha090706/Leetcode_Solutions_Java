class ListNode {
    int key;
    int val;
    int freq;
    ListNode prev;
    ListNode next;
    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
        prev = null;
        next = null;
    }
}
class DoublyLinkedList {
    ListNode head;
    ListNode tail;
    int size;
    DoublyLinkedList() {
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;

        size = 0;
    }
    void addFirst(ListNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    ListNode removeLast() {
        if(head.next == tail) {
            return null;
        }
        ListNode node = tail.prev;
        remove(node);
        return node;
    }
    boolean isEmpty() {
        return head.next == tail;
    }
}

class LFUCache {
    int capacity;
    int minFreq;
    HashMap<Integer, ListNode> map;
    HashMap<Integer, DoublyLinkedList> freq;
    public LFUCache(int capacity) {
       this.capacity = capacity;
       minFreq = 1;
       map = new HashMap<>();
       freq = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        increaseFrequency(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            increaseFrequency(node);
            return;
        }
        if(map.size() == capacity) {
            DoublyLinkedList list = freq.get(minFreq);
            ListNode removed = list.removeLast();
            map.remove(removed.key);
        }

        ListNode node = new ListNode(key, value);
        map.put(key, node);
        DoublyLinkedList list;
        if(freq.containsKey(1)) {
            list = freq.get(1);
        }
        else {
            list = new DoublyLinkedList();
            freq.put(1, list);
        }
        list.addFirst(node);
        minFreq = 1;
    }
    public void increaseFrequency(ListNode node){
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freq.get(oldFreq);
        oldList.remove(node);
        if(oldFreq == minFreq && oldList.isEmpty()) {
            minFreq++;
        }
        node.freq++;
        DoublyLinkedList newList;
        if (freq.containsKey(node.freq)) {
            newList = freq.get(node.freq);
        } 
        else {
            newList = new DoublyLinkedList();
            freq.put(node.freq, newList);
        }
        newList.addFirst(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */