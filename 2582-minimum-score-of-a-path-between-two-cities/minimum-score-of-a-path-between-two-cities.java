class Solution {
    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] road: roads) {
            int u = road[0];
            int v = road[1];
            int d = road[2];
            adj.get(u).add(new int[]{v, d});
            adj.get(v).add(new int[]{u, d});
        }

        boolean[] visited = new boolean[n + 1];
        int score = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()) {
            int u = q.poll();
            for(int[] neigh : adj.get(u)) {
                int v = neigh[0];
                int d = neigh[1];
                score =  Math.min(score ,d);
                if(!visited[v]) {
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
        return score;
    }
    
}