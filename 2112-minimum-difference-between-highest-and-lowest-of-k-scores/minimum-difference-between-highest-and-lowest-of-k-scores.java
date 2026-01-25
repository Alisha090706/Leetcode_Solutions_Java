class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = k-1;
        int ans = Integer.MAX_VALUE;
        while(j < n){
            ans = Math.min(ans, nums[j]-nums[i]);
            i++;
            j++;
        }
        return ans;
        
    }
}