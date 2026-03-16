class Solution {
    List<String> result = new ArrayList<>();
    int n;
    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        solve(s, 0, 0, new StringBuilder());
        return result;
    }
    public void solve(String s, int i, int segments, StringBuilder sb) {
        if(segments == 4 && i == n){
            result.add(sb.substring(0, sb.length() - 1));
            return;
        }
        if(segments == 4 || i == n) return;
        int num = 0;
        for(int j = i; j < n && j < i + 3; j++){
            num = num * 10 + (s.charAt(j) - '0');
            if(num > 255) break;
            int len = sb.length();
            sb.append(num).append('.');
            solve(s, j + 1, segments + 1, sb);
            sb.setLength(len);
            if (s.charAt(i) == '0') break;
        }
    }
}