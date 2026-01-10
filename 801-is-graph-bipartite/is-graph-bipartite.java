class Solution {
    public boolean isBipartite(int[][] graph) {
        int m=graph.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<m;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int[] edge=graph[i];
            for(int n:edge){
                adj.get(i).add(n);
                adj.get(n).add(i);
            }
        }
        int[] color=new int[m];
        Arrays.fill(color,-1);
        for(int i=0;i<m;i++){
            if(color[i]==-1 && !dfs(adj,i,color,0)) return false;
        }
        return true;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int u,int[] color,int c){
        color[u]=c;
        for(int v:adj.get(u)){
            if(color[v] == color[u]) return false;
            if(color[v] == -1){
                if(!dfs(adj,v,color,1-c)) return false;
            }
        }
        return true;
    }
}