class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int curr = 0;
        int count = 0;
        for(int i = 0; i < n; i++) {
            curr += nums[i];
            if(map.containsKey(curr - k)) {
                count += map.get(curr - k);
            }
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return count;
    }
}