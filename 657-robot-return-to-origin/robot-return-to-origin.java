class Solution {
    public boolean judgeCircle(String moves) {
        int n = moves.length();
        int positionx = 0;
        int positiony = 0;
        for(char c: moves.toCharArray()) {
            if(c == 'L') positionx -= 1;
            else if(c == 'R') positionx += 1;
            else if(c == 'U') positiony -= 1;
            else positiony += 1;
        }
        return positionx == 0 && positiony == 0;
    }
}