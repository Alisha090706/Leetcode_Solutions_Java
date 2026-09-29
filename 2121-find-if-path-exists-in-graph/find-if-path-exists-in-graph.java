class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(source);
        visited[source] = true;
        while(!q.isEmpty()) {
            int curr = q.poll();
            if(curr == destination) return true;
            for(int v : adj.get(curr)) {
                if(!visited[v]) {
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
        return false;
    }
}