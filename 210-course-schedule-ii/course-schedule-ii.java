class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n  = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }
        return toposort(n, adj, prerequisites);
    }
    public int[] toposort(int n, ArrayList<ArrayList<Integer>> adj, int[][] prerequisites) {
        int[] indegree = new int[n];
        for(int[] p: prerequisites) {
            indegree[p[0]]++;
        }
        int[] result = new int[n];
        Queue<Integer> q = new LinkedList<>();
        int idx = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
                result[idx++] = i;
                visited[i] = true;
            }
        }
        int count = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            count++;
            for(int v : adj.get(curr)) {
                if(!visited[v]) {
                    indegree[v]--;
                    if(indegree[v] == 0) {
                        q.add(v);
                        visited[v] = true;
                        result[idx++] = v;
                    }
                }
            }
        }
        return count == n ? result : new int[]{};
    }
}