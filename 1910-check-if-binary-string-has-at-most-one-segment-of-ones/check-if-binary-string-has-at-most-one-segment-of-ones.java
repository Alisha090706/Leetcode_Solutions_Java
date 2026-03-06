class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int len = 1;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == '1'){
                if(len == 0) return false;
            }
            else{
                len = 0;
            }
        }
        return true;
    }
}