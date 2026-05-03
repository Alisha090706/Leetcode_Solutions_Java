class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        for(int i = 0; i < n; i++) {
            String curr = s.substring(i, n) + s.substring(0, i);
            if(goal.equals(curr)) return true;
        }
        return false;
        
    }
}