class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int[] parent = new int[n];
        int[] rank = new int[n];
        int result = 0;
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for(int[] swaps : allowedSwaps) {
            int a = swaps[0];
            int b = swaps[1];
            union(parent, rank, a, b);
        }
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int root = find(parent, i);
            map.putIfAbsent(root, new HashMap<>());
            HashMap<Integer, Integer> freq = map.get(root);

            freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
        }
        for(int i = 0; i < n; i++) {
            int root = find(parent, i);
            HashMap<Integer, Integer> freq = map.get(root);

            if(freq.getOrDefault(target[i], 0) > 0) {
                freq.put(target[i], freq.get(target[i]) - 1);
            } else {
                result++;
            }
        }

        return result;
    }
    public void union(int[] parent, int[] rank, int x, int y) {
        int x_p = find(parent, x);
        int y_p = find(parent, y);
        if(x_p == y_p) return;
        if(rank[x_p] < rank[y_p]) {
            parent[x_p] = y_p;
        }
        else if(rank[x_p] > rank[y_p]) {
            parent[y_p] = x_p;
        }
        else{
            parent[y_p] = x_p;
            rank[x_p]++;
        }
    }
    public int find(int[] parent, int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent, parent[x]);
    }
}