class Solution {
    int[][] dp;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        dp = new int[m][n];
        for(int[] row: dp) Arrays.fill(row ,-1000000000);
        return solve(nums1, nums2, m-1, n-1);
    }
    public int solve(int[] nums1, int[] nums2, int m, int n){
        if(m < 0 || n < 0) return -1000000000;
        
        if(dp[m][n] != -1000000000) return dp[m][n];
        // case 1 
        int a = nums1[m] * nums2[n];

        //case 2
        int b = solve(nums1, nums2, m-1, n-1) + a;

        //case 3
        int c = solve(nums1, nums2, m-1, n);

        //case 4
        int d = solve(nums1, nums2, m, n-1);

        return dp[m][n] = Math.max(Math.max(a,b), Math.max(c,d));
    }
}