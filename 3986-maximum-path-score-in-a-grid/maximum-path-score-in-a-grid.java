class Solution {
    int m;
    int n;
    int maxcost;
    int[][][] dp;
    public int maxPathScore(int[][] grid, int k) {
        m=grid.length;
        n=grid[0].length;
        maxcost=k;
        dp=new int[m][n][k+1];
        for(int[][] box:dp){
            for(int[] row:box)Arrays.fill(row,-2);
        }
        int ans=solve(grid,0,0,0);
        return ans<0?-1:ans;
    }
    public int solve(int[][]grid,int i,int j,int cost){
        if(i>=m || j>=n || cost>maxcost) return Integer.MIN_VALUE;
        if(i==m-1 && j==n-1){
            int curr=0;
            if(grid[i][j]==1||grid[i][j]==2)curr=1;
            if(curr+cost>maxcost)return Integer.MIN_VALUE;
            return grid[i][j];
        }
        if(dp[i][j][cost]!=-2) return dp[i][j][cost];
        int currcost=0;
        if(grid[i][j]==1 || grid[i][j]==2) currcost=1;

        int right=solve(grid,i+1,j,currcost+cost);
        int down=solve(grid,i,j+1,currcost+cost);
        return dp[i][j][cost]=grid[i][j]+Math.max(right,down);
    }
}