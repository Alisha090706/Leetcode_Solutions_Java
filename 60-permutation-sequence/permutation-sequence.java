class Solution {
    ArrayList<String> permutations = new ArrayList<>();
    boolean[] visited;
    int K;
    public String getPermutation(int n, int k) {
        K = k;
        visited = new boolean[n+1];
        solve(n, new StringBuilder());
        return permutations.get(k - 1);
    }
    public void solve(int n, StringBuilder sb){
        if(permutations.size() >= K) return;
        if(sb.length() == n){
            permutations.add(sb.toString());
            return;
        }
        for(int i = 1; i <= n; i++){
            if(visited[i]) continue;
            sb.append(i);
            visited[i] = true;
            solve(n, sb);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}