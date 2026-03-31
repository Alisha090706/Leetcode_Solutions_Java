class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        if(n == 1) return n;
        int un = 1;
        q.add(1L);
        while(!q.isEmpty()) {
            long curr = q.poll();
            if(un == n) return (int)curr;
            long a = curr * 2;
            long b = curr * 3;
            long c = curr * 5;
            if(!set.contains(a)) {
                set.add(a);
                q.add(a);
            }
            if(!set.contains(b)) {
                set.add(b);
                q.add(b);
            }
            if(!set.contains(c)) {
                set.add(c);
                q.add(c);
            }
            
            un++;
        }
        return -1;


    }
}