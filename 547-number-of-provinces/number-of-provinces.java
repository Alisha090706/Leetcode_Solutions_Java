class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int u = 0;u<V;u++){
            for(int v=0;v<V;v++){
                if(u!=v && isConnected[u][v]==1){
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }
            }
        }
        boolean[] visited = new boolean[V];
        int count = 0;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                bfs(adj,i,visited);
                count++;
            }
        }
        return count;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,int u,boolean[] visited){
        visited[u]= true;
        for(int v:adj.get(u)){
            if(!visited[v]) dfs(adj,v,visited);
        }
        
    }
    public void bfs(ArrayList<ArrayList<Integer>> adj,int u,boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        visited[u]=true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int v: adj.get(curr)){
                if(!visited[v]){
                    visited[v]=true;
                    q.add(v);
                }
            }
        }
    }
}