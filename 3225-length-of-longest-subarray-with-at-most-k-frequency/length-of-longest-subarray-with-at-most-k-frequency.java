class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int i = 0;
        int j = 0;
        while(j < n) {
            int num = nums[j];
            map.put(num, map.getOrDefault(num, 0) + 1);
            while(map.containsKey(num) && map.get(num) > k) {
                int num2 = nums[i];
                map.put(num2, map.get(num2) - 1);
                if(map.get(num2) == 0) map.remove(num2);
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }
    
}