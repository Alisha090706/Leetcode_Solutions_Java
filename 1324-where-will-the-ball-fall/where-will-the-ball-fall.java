class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[n];
        for(int col = 0; col < n; col++){
            int currcol = col;
            for(int row = 0; row < m; row++){
                if(currcol < 0 || currcol >= n) {
                    result[col] = -1;
                    break;
                }
                else if(grid[row][currcol] == 1){
                    if(currcol + 1 < n){
                        if(grid[row][currcol + 1] == -1){
                            result[col] = -1;
                            break;
                        }
                        else{
                            currcol++;
                        }
                    }
                    else{
                        result[col] = -1;
                        break;
                    }
                }
                else{
                    if(currcol - 1 >= 0){
                        if(grid[row][currcol - 1] == 1){
                            result[col] = -1;
                            break;
                        }
                        else{
                            currcol--;
                        }
                    }
                    else{
                        result[col] = -1;
                        break;
                    }

                }

            }
            if(result[col]!=-1){
                result[col] = currcol;
            }
        }
        return result;
    }
}