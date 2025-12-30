class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        //Brute Force - Iterating over nums for each value to find the sum that is equal to target
        // TC = O(N^2)

        //Optimized Technique - Using HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        //map -> (number,index);
        map.put(nums[0], 0);
        for (int i = 1; i < n; i++) {
            int otherNum = target - nums[i];
            if (map.containsKey(otherNum)) {
                return new int[] { map.get(otherNum), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};

    }
}