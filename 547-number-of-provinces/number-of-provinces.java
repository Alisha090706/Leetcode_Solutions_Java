class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {
            int u = i + 1;
            for(int j = 0; j < n; j++) {
                if(isConnected[i][j] == 0 || i == j) continue;
                adj.get(u).add(j + 1);
                adj.get(j + 1).add(u);
            }
        }
        boolean[] visited = new boolean[n + 1];
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                dfs(adj, i, visited);
                count++;
            }
        }
        return count;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited) {
        visited[u] = true;
        for(int v : adj.get(u)) {
            if(!visited[v]) {
                dfs(adj,v, visited);
            }
        }
    }
}