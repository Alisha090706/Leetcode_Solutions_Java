class Solution {
    int n;
    static long INF = Long.MAX_VALUE;
    List<Integer> topo;
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        n = online.length;
        int score = -1;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int low = Integer.MAX_VALUE;
        int high = 0;
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            adj.get(u).add(new int[]{v, cost});
            low = Math.min(low, cost);
            high = Math.max(high, cost);
        }
        topo = toposort(edges, adj);
        while(low <= high) {
            int mid = low + (high - low) / 2;
            long totalCost = solve(adj, mid, online);
            if(totalCost <= k) {
                score = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return score;
    }
    public long solve(ArrayList<ArrayList<int[]>> adj, int mid, boolean[] online) {
        long[] dp = new long[n];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for(int u: topo) {
            if(dp[u] == INF) continue;
            if (u != 0 && u != n - 1 && !online[u]) continue;
            for(int[] edge: adj.get(u)) {
                int v = edge[0];
                int cost = edge[1];
                if(cost < mid) continue;
                if (!online[v] && v != n-1) continue;

                dp[v] = Math.min(dp[v], dp[u] + cost);
            }
        }
        return dp[n - 1];
    }
    public List<Integer> toposort(int[][] edges, ArrayList<ArrayList<int[]>> adj) {
        int[] indegree = new int[n];
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            indegree[v] ++;
        }
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            list.add(curr);
            for(int[] edge: adj.get(curr)) {
                int v = edge[0];
                indegree[v] --;
                if(indegree[v] == 0) {
                    q.add(v);
                }
            }
        }
        return list;
    }
}