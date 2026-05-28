class Solution {
    int sum = 0;
    public int subsetXORSum(int[] nums) {
        solve(nums, 0, 0);
        return sum;
    }
    public void solve(int[] nums, int i, int xor) {
        if(i == nums.length) {
            sum += xor;
            return;
        }

        //take
        solve(nums, i + 1, xor ^ nums[i]);

        //not take
        solve(nums, i + 1, xor);
    }
}