class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int children = 0;
        int j = 0;
        for(int i = 0; i < n;i++){
            int greed = g[i];
            while(j < m && s[j] < greed){
                j++;
            }
            if(j<m && s[j] >= greed){
                children++;
                j++;
            }
        }
        return children;
    }
}