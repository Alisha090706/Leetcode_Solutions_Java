class Solution {
    public String makeSmallestPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;
        StringBuilder sb = new StringBuilder(s);
        while(i < j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if(c1 < c2) {
                sb.setCharAt(j, c1);
            }
            else {
                sb.setCharAt(i, c2);
            }
            i++;
            j--;
        }
        return sb.toString();
        
    }
}