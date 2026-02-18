class Solution {
    int count = 0;
    int N;
    public int totalNQueens(int n) {
        N = n;
        char[][] board = new char[N][N];
        for(char[] row: board) Arrays.fill(row, '.');
        solve(n, 0, board);
        return count;
    }
    public void solve(int n, int col, char[][] board){
        if(n == 0){
            count += 1;
            return ;
        }
        if(col >= N) return;

        for(int row = 0; row < N; row++){
            if(isValid(board, row, col)){
                board[row][col] = 'Q';
                solve(n-1,col+1,board);
                board[row][col] = '.';
            }
        }
    }
    public boolean isValid(char[][] board, int row, int col){
        for(int i = 0; i < N; i++){
            if(board[row][i] == 'Q') return false;
        }
        //upper diagonal
        int i = row -1;
        int j = col -1;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        //lower diagonal
        i = row + 1;
        j = col - 1;
        while(i < N && j >= 0){
            if(board[i][j] == 'Q') return false;
            i++;
            j--;
        }
        return true;
    }
}