class Solution {
    public boolean isNumber(String s) {
        int n = s.length();
        if(n == 1 && "-+.eE".indexOf(s.charAt(0)) != -1) return false;
        boolean exp = false;
        boolean num = false;
        boolean dot = false;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if((c >= 'a' && c <= 'z' && c != 'e') || (c >= 'A' && c <='Z' && c != 'E')) return false;
            if(i == n - 1 && ("-+eE".indexOf(c) != -1)) return false;
            if(c == 'e' || c == 'E'){
                if(exp || !num) return false;
                exp = true;
                num = false;
            }
            else if(c == '+' || c == '-'){
                if(i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            }
            else if(c == '.'){
                if(exp || dot) return false;
                dot = true;
            }
            else{
                num = true;
            }
        }
        return num;
        
    }
}