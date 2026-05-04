class Solution {
    List<List<String>> result = new ArrayList<>();
    int N;
    public List<List<String>> solveNQueens(int n) {
        N = n;
        char[][] board = new char[n][n];
        for(char[] row: board) Arrays.fill(row, '.');
        solve(board, 0, n);
        return result;
    }
    public void solve(char[][] board, int col, int queens) {
        if(queens == 0) {
            result.add(construct(board));
            return;
        }
        if(col >= N) return;

        for(int i = 0; i < N ;i++) {
            if(isValid(board,i,col)) {
                board[i][col] = 'Q';
                solve(board, col + 1, queens - 1);
                board[i][col] = '.';
            }
        }
    }
    public boolean isValid(char[][] board, int row, int col) {
        for(int i = 0; i < N; i++) {
            if(board[row][i] == 'Q' || board[i][col] == 'Q') return false;
        }
        //upper diagonal
        int i = row;
        int j = col;
        while(i >= 0 && j >= 0) {
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }

        //lower diagonal
        i = row;
        j = col;
        while(i < N && j >= 0) {
            if(board[i][j] == 'Q') return false;
            i++;
            j--;
        }
        return true;
    }
    public ArrayList<String> construct(char[][] board){
        ArrayList<String> output=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<board.length;j++){
                sb.append(board[i][j]);
            }
            output.add(sb.toString());
        }
        return output;
    }
}