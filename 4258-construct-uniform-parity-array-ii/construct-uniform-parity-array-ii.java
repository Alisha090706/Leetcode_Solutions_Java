class Solution {
    public boolean uniformArray(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int num: nums) {
            if(num % 2 != 0) {
                min = Math.min(min, num);
            }
        }
        if(min == Integer.MAX_VALUE) return true;

        for(int num: nums) {
            if(num % 2 == 0 && num < min) return false;
        }
        return true;
        
    }
}