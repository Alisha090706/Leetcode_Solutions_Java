class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] preq : prerequisites){
            int u = preq[0];
            int v = preq[1];
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecur = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!visited[i] && dfs(adj,i,visited,inRecur)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, boolean[] inRecur){
        visited[u] =true;
        inRecur[u] = true;
        for(int v: adj.get(u)){
            
            if(!visited[v]){
                if(dfs(adj, v, visited, inRecur)) return true;
            }
            else if(inRecur[v]){
                return true;
            }
        }
        inRecur[u] = false;
        return false;
    }
}