class Solution {
    public String processStr(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(c <= 'z' && c >= 'a') {
                sb.append(c);
            }
            else if(c == '*') {
                int len = sb.length();
                if(len > 0) {
                    sb.deleteCharAt(len - 1);
                }
            }
            else if(c == '#') {
                String d = sb.toString();
                sb.append(d);
            }
            else {
                sb.reverse();
            }

        }
        return sb.toString();
    }
}