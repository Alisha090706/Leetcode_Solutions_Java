class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        solve(n,0,0,new StringBuilder());
        return result;
    }
    public void solve(int n,int op,int cl, StringBuilder sb){
        if(cl == n){
            result.add(sb.toString());
            return;
        }
        if(op < n) {
            sb.append('(');
            solve(n, op + 1, cl, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(cl < op){
            sb.append(')');
            solve(n, op, cl + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}