class Solution {
    int n;
    int[][] dp;
    public int maxCollectedFruits(int[][] fruits) {
        n = fruits.length;
        dp = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[i] = fruits[i].clone();

        int result = child1Collect(fruits);
        for(int i = 0; i<n; i++){
            for(int j=0;j<n;j++){
                int val =fruits[i][j];
                if(i<j && i+j<n-1){
                    dp[i][j]=0;
                }
                else if(i>j && i+j<n-1){
                    dp[i][j] = 0;
                }
            }
        }
        //child2 collects
        for(int i=1;i<n;i++){
            for(int j=i+1;j<n;j++){
                int a = dp[i-1][j];
                int b = dp[i-1][j-1];
                int c = (j+1<n)?dp[i-1][j+1]:0;
                dp[i][j]+=Math.max(a,Math.max(b,c));
            }
        }
        //child3 collects
        for(int j=1;j<n;j++){
            for(int i=j+1;i<n;i++){
                int a = dp[i-1][j-1];
                int b = dp[i][j-1];
                int c = i+1<n?dp[i+1][j-1]:0;
                dp[i][j]+=Math.max(a,Math.max(b,c));
            }
        }
        return result+dp[n-2][n-1]+dp[n-1][n-2];

        
        // for(int[] row: dp)Arrays.fill(row, -1);
        // int child_one = child1Collect(fruits);
        // int child_two = child2Collect(fruits,0,n-1,0);
        // int child_three = child3Collect(fruits,n-1,0,0);

        // return child_one + child_two + child_three;
    }
    public int child1Collect(int[][] fruits){
        int result = 0;
        for(int i= 0;i<n;i++){
            result+=fruits[i][i];
            
        }
        return result;
    }
    public int child2Collect(int[][] fruits,int i,int j,int moves){
        if(moves >= n || i>=j) return 0;
        if(j>=n || j<0) return 0;
        if(i==n-1 && j==n-1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int val = fruits[i][j];
        int a = child2Collect(fruits,i+1,j+1,moves+1);
        int b = child2Collect(fruits,i+1,j-1,moves+1);
        int c = child2Collect(fruits,i+1,j,moves+1);
        return dp[i][j] = val + Math.max(a,Math.max(b,c));
    }
    public int child3Collect(int[][] fruits,int i,int j,int moves){
        if(moves >= n || i<=j) return 0;
        if(i>=n || i<0) return 0;
        if(i==n-1 && j==n-1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int val = fruits[i][j];
        int a = child3Collect(fruits,i+1,j+1,moves+1);
        int b = child3Collect(fruits,i,j+1,moves+1);
        int c = child3Collect(fruits,i-1,j+1,moves+1);
        return dp[i][j] = val + Math.max(a,Math.max(b,c));
    }
    
}