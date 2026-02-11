class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i + 1;
            int k = n - 1;
            
            while(j < k){
                int sum = nums[j] + nums[k] + nums[i];
                if(Math.abs(sum - target ) < Math.abs(ans - target )){
                    ans = sum;
                }
                if(sum < target){
                    j++;
                }
                else if (sum > target) k--;
                else return target;
            }
            
        }
        return ans;
    }
}