class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] adj = new int[26][26];
        for(int[] row: adj) Arrays.fill(row, Integer.MAX_VALUE);
        for(int i = 0; i < original.length; i++){
            int j = original[i] - 'a';
            int k = changed[i] - 'a';
            int c = cost[i];
            adj[j][k] = Math.min(adj[j][k], c);
        }

        for(int k = 0; k < 26; k++){
            for(int i = 0; i < 26; i++){
                for(int j = 0; j < 26; j++){
                    if(adj[i][k] != Integer.MAX_VALUE &&
                    adj[k][j] != Integer.MAX_VALUE &&
                    adj[i][k] + adj[k][j] < adj[i][j]){
                        adj[i][j] = adj[i][k] + adj[k][j];
                    }
                }
            }
        }

        long minCost = 0;
        for(int i = 0; i < source.length(); i++){
            int s = source.charAt(i) -'a';
            int t = target.charAt(i) - 'a';
            if(s == t) continue;
            if(adj[s][t] == Integer.MAX_VALUE) return -1;
            else minCost += adj[s][t];
        }
        return minCost;

    }
}