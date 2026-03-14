class Solution {
    char[] letters = {'a', 'b', 'c'};
    ArrayList<String> list = new ArrayList<>();
    public String getHappyString(int n, int k) {
        solve(n, new StringBuilder(),'*');
        return list.size() < k? "" : list.get(k - 1);
    }
    public void solve(int n, StringBuilder sb,char prev) {
        if(n == 0) {
            list.add(sb.toString());
            return;
        }

        for(char ch : letters){
            if(prev == ch) continue;
            sb.append(ch);
            solve(n - 1, sb, ch);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}