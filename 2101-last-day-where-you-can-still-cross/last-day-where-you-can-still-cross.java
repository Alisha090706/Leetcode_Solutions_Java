class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int n=cells.length;
        int l=0;
        int r=n-1;
        int answer=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            int[][] grid=new int[row][col];
            for(int i=0;i<=mid;i++){
                int x=cells[i][0];
                int y=cells[i][1];
                grid[x-1][y-1]=1;
            }
            boolean poss=false;
            boolean[][] visited=new boolean[row][col];
            for(int i=0;i<col;i++){
                if(grid[0][i]==0 && dfs(grid,0,i,poss,visited)){
                    poss=true;
                    break;
                }
                
            }
            if(poss){
                answer=mid+1;
                l=mid+1;
            }
            else{
                r=mid-1;
            }

        }
        return answer;
    }
    public boolean dfs(int[][] grid,int row,int col,boolean poss,boolean[][] visited){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]==1 || visited[row][col]) return false;

        if(row==grid.length-1){
            return true;
        }
        visited[row][col]=true;

        return (dfs(grid,row+1,col,poss,visited) ||
        dfs(grid,row-1,col,poss,visited)||
        dfs(grid,row,col+1,poss,visited)||
        dfs(grid,row,col-1,poss,visited));
    }
}