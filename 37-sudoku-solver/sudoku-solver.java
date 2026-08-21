class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);

    }
    public boolean solve(char[][] grid){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(grid[i][j] == '.'){
                    for(char d = '1'; d <= '9'; d++){
                        if(isValid(grid,i,j,d)){
                            grid[i][j] = d;
                            if(solve(grid)) return true;
                            grid[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] grid, int row,int col ,char d){
        for(int i = 0; i < 9; i++){
            if(grid[row][i] == d) return false;
            if(grid[i][col] == d) return false;
        }
        int start_i = (row/3)*3;
        int start_j = (col/3)*3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(grid[i + start_i][j + start_j] == d) return false;
            }
        }
        return true;
    }
}