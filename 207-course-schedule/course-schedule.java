class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }
        if(hasCycle(n, adj, prerequisites)) return false;
        return true;
    }
    public boolean hasCycle(int n, ArrayList<ArrayList<Integer>> adj, int[][] edges) {
        int[] indegree = new int[n];
        for(int[] e : edges) {
            indegree[e[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
                visited[i] = true;
            }
        }
        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int curr = q.poll();
                count++;
                for(int v : adj.get(curr)) {
                    if(visited[v]) continue;
                    indegree[v]--;
                    if(indegree[v] == 0) {
                        q.add(v);
                        visited[v] = true;
                    }
                }
            }
        }
        return !(count == n);
    }
}