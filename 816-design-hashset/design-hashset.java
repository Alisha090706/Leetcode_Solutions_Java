class MyHashSet {
    ArrayList<Integer> set;
    public MyHashSet() {
        set = new ArrayList<>();
    }
    
    public void add(int key) {
        if(contains(key)) return;
        set.add(key);
    }
    
    public void remove(int key) {
        if(!contains(key)) return;
        for(int i = 0; i < set.size(); i++) {
            if(set.get(i) == key) {
                set.remove(i);
                break;
            }
        }
    }
    
    public boolean contains(int key) {
        for(int num: set) {
            if(num == key) return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */