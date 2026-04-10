class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        int minDis = Integer.MAX_VALUE;
        for(int num: map.keySet()) {
            int size = map.get(num).size();
            if(size < 3) continue;
            for(int i = 2; i < size; i++) {
                int a = map.get(num).get(i - 2);
                int b = map.get(num).get(i - 1);
                int c = map.get(num).get(i);
                int dist = Math.abs(a - b) + Math.abs(b - c) + Math.abs(c - a);
                minDis = Math.min(minDis, dist);
            }
        }
        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }
}