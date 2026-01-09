class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int triangles = 0;
        for(int k = n-1; k >= 2; k--){
            int i = 0;
            int j = k-1;
            while(i<j){
                if(nums[k] < nums[i] + nums[j]){
                    triangles += (j-i);
                    j--;
                }
                else{
                    i++;
                }
            }
        }
        return triangles;
    }
}