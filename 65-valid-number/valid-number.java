class Solution {
    public boolean isNumber(String s) {
        int n = s.length();
        if(n == 1 && "-+.eE".indexOf(s.charAt(0)) != -1) return false;
        boolean exp = false;
        boolean num = false;
        boolean dot = false;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = true;
            }
            else if(c == '+' || c == '-'){
                // sign allowed only at start or right after e/E
                if(i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            }
            else if(c == '.'){
                // dot not allowed after exponent
                if(dot || exp) return false;
                dot = true;
            }
            else if(c == 'e' || c == 'E'){
                // exponent must appear once
                // and must have digit before it
                if(exp || !num) return false;
                num = false; // must have digit after it
                exp = true;
            }
            else return false;
        }
        return num;
        
    }
}