class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] preq: prerequisites){
            int u = preq[0];
            int v = preq[1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        //Kahn's Algorithm of TopoSort
        //If we are able to find there is a cycle then we can return false else true;
        return toposort(adj,numCourses,indegree);
    }
    public boolean toposort(ArrayList<ArrayList<Integer>> adj,int n,int[] indegree){
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i <n ;i++){
            if(indegree[i] == 0) q.add(i);
        }
        int count = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            for(int v: adj.get(curr)){
                indegree[v]--;
                if(indegree[v] == 0) q.add(v);
            }
        }
        return count == n;
    }
}