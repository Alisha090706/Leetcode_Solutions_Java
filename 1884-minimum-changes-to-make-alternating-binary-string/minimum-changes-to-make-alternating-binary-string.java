class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int start0 = 0;
        int start1 = 0;

        for(int i = 0; i < n ;i++){
            char c = s.charAt(i);
            if(i % 2 == 0){
                if(c == '0') start1++;
                else start0++;
            }
            else{
                if(c == '1') start1++;
                else start0++;
            }
        }
        return Math.min(start1, start0);
    }
}