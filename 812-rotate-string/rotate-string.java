class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        if(goal.length() != n) return false;
        s = s + s;
        if(s.indexOf(goal) != -1) return true;
        return false;
    }
}