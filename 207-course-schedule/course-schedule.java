class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] prerequisite:prerequisites){
            int u=prerequisite[0];
            int v=prerequisite[1];
            adj.get(u).add(v);
        }
        boolean[] visited=new boolean[numCourses];
        boolean[] inrec=new boolean[numCourses];
        
        for(int i=0;i<numCourses;i++){
            if(!visited[i] && dfs(adj,i,visited,inrec)) return false;
        }
        return true;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int u,boolean[] visited, boolean[] inrec){
        visited[u]=true;
        inrec[u]=true;
        
        for(int v:adj.get(u)){
            if(!visited[v] && dfs(adj,v,visited,inrec))return true;
            else if(inrec[v]) return true;
        }
        inrec[u]=false;
        return false;
    }
}