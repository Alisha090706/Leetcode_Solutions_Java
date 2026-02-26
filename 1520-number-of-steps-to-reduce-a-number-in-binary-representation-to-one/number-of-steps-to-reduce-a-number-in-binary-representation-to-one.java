class Solution {
    public int numSteps(String s) {
        int steps = 0;
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        while(sb.length() != 1){
            int n = sb.length();
            
            if(sb.charAt(0) == '0'){
                sb.deleteCharAt(0);
            }
            else{
                int carry = 1;
                int idx = 0;
                while(carry != 0 && idx < sb.length()){
                    int digit = sb.charAt(idx) - '0';
                    int sum = carry + digit;
                    int num = sum % 2;
                    sb.setCharAt(idx,(char)(num + '0'));
                    carry = sum / 2;
                    idx ++;
                }
                if(carry == 1) sb.append(1);
            }
            steps ++;
        }
        return steps;
    }
}