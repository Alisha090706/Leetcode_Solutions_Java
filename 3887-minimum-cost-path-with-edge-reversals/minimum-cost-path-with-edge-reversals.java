class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int d = edge[2];
            adj.get(u).add(new int[]{v,d});
            adj.get(v).add(new int[]{u,2*d});
        }
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        q.add(new int[]{0,0});
        cost[0] = 0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int u = curr[0];
            int dist = curr[1];
            if(u == n-1) return dist;
            for(int[] neigh : adj.get(u)){
                int v = neigh[0];
                int d = neigh[1];
                if(d + dist < cost[v]){
                    cost[v] = d + dist;
                    q.add(new int[]{v,cost[v]});
                    
                }
            }
        }
        return -1;
    }

}