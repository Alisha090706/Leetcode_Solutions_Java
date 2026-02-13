class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, HashSet<Character>> row = new HashMap<>();
        Map<Integer, HashSet<Character>> col = new HashMap<>();
        Map<Integer, HashSet<Character>> box = new HashMap<>();

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                char ch = board[r][c];
                if(ch == '.') continue;
                int b = (r/3)*3+(c/3);

                row.putIfAbsent(r, new HashSet<>());
                col.putIfAbsent(c, new HashSet<>());
                box.putIfAbsent(b, new HashSet<>());

                if(row.get(r).contains(ch) ||
                col.get(c).contains(ch) ||
                box.get(b).contains(ch)) return false;

                row.get(r).add(ch);
                col.get(c).add(ch);
                box.get(b).add(ch);
            }
        }
        return true;
    }
}