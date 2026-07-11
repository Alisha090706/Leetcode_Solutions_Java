class Solution {
    int[] verticesInOneComp;
    public int countCompleteComponents(int n, int[][] edges) {

        int answer = 0;

        //so to find connected components -> union and find
        // for every sub graph -> calculate total number of edges (nC2)
        //step 1 : make all components
        int[] parent = new int[n];
        int[] rank = new int[n];
        verticesInOneComp = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.fill(verticesInOneComp, 1);
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            if(find(parent, u) != find(parent, v)) {
                union(parent, rank, u, v);
            }
        }

        //step 2: count total edges
        HashMap<Integer,Integer> edgeCount = new HashMap<>();

        for(int[] edge : edges){
            int root = find(parent, edge[0]);
            edgeCount.put(root,
                edgeCount.getOrDefault(root,0)+1);
        }
        HashSet<Integer> seen = new HashSet<>();

        for(int i = 0; i < n; i++){
            int root = find(parent, i);
            if(seen.contains(root))
                continue;
            seen.add(root);
            int vertices = verticesInOneComp[root];
            int expectedEdges = vertices * (vertices - 1) / 2;
            int actualEdges = edgeCount.getOrDefault(root, 0);
            if(expectedEdges == actualEdges)
                answer++;
        }
        return answer;
    }

    public int find(int[] parent, int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent, parent[x]);
    }

    public void union(int[] parent, int[] rank, int x, int y) {
        int xp = find(parent, x);
        int yp = find(parent, y);

        if(xp == yp) return;

        if(rank[xp] < rank[yp]) {
            parent[xp] = yp;
            verticesInOneComp[yp] += verticesInOneComp[xp] ;
        }
        else if(rank[xp] > rank[yp]) {
            parent[yp] = xp;
            verticesInOneComp[xp] += verticesInOneComp[yp];
        }
        else {
            parent[xp] = yp;
            rank[yp]++;
            verticesInOneComp[yp] += verticesInOneComp[xp];
        }
    }

    public int countEdges(ArrayList<ArrayList<Integer>> adj, int u, int n) {
        int count = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        visited[u] = true;

        while(!q.isEmpty()) {
            int curr = q.poll();

            count += adj.get(curr).size();

            for(int v : adj.get(curr)){
                if(!visited[v]){
                    visited[v]=true;
                    q.add(v);
                }
            }
        }
        return count / 2;
    }
}