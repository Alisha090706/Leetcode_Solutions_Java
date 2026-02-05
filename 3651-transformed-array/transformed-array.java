class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                result[i] = nums[i];
            }
            else{
                int newidx = (i + nums[i])%n;
                if(newidx < 0){
                    newidx += n;
                }
                result[i] = nums[newidx];
            }
        }
        return result;
    }
    
}