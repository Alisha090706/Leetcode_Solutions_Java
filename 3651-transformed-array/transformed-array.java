class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                result[i] = nums[i];
            }
            else if(nums[i] > 0){
                result[i] = right(nums,i,nums[i]);
            }
            else{
                result[i] = left(nums,i,Math.abs(nums[i]));
            }
        }
        return result;
    }
    public int right(int[] nums,int start,int end){
        int n = nums.length;
        while(end-- > 0){
            start = (start + 1) % n;
        }
        return nums[start];
    }
    public int left(int[] nums,int start,int end){
        int n = nums.length;
        while(end-- > 0){
            start = (start - 1) % n;
            if(start < 0){
                start = n-1;
            }
        }
        return nums[start];
    }
}