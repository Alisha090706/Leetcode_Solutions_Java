class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int sub = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        for(int i = 0 ; i < n; i++){
            sum += nums[i];
            int prev = sum - k;
            if(map.containsKey(prev)){
                sub +=  map.get(prev);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return sub;
    }
}