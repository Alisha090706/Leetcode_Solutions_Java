class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int n = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] p: prerequisites) {
            adj.get(p[0]).add(p[1]);
        }

        List<Boolean> result = new ArrayList<>();

        for(int[] q : queries) {
            result.add(solve(n, adj, q[0], q[1]));
        }
        return result;
    }
    public boolean solve(int n, ArrayList<ArrayList<Integer>> adj, int source, int dest) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        boolean[] visited = new boolean[n];
        visited[source] = true;
        while(!q.isEmpty()) {
            int u = q.poll();
            if(u == dest) return true;
            for(int v : adj.get(u)) {
                if(!visited[v]) {
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
        return false;
    }
}