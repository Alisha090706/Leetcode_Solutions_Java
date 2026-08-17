class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            int num = nums[i];
            while(!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.removeLast();
            }

            while(!q.isEmpty() && i - q.peekFirst() >= k) {
                q.removeFirst();
            }
            q.addLast(i);
            if(i >= k - 1) {
                list.add(q.peekFirst());
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = nums[list.get(i)];
        }
        return result;
    }
}