class Solution {
    public long rob(int[] nums, int[] colors) {
        int n = nums.length;
        if(n == 1) return nums[0];
        long take = nums[0];
        long skip = 0;
        for(int i = 1; i < n; i++){
            long newtake;
            long newnottake = Math.max(take, skip);

            if(colors[i] == colors[i-1]){
                newtake = nums[i] + skip;
            }
            else{
                newtake = Math.max(take, skip) + nums[i];
            }
            skip = newnottake;
            take = newtake;
        }
        return Math.max(take ,skip);
        
    }
}