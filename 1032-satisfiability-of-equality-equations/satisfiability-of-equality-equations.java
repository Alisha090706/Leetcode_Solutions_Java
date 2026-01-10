class Solution {
    public boolean equationsPossible(String[] equations) {

        int[] parent = new int[26];
        for(int i=0;i<26;i++){
            parent[i]=i;
        }
        int[] rank = new int[26];
        for(String s:equations){
            if(s.charAt(1) == '='){
                char a = s.charAt(0);
                char b = s.charAt(3);
                union(a-'a',b-'a',parent,rank);
             }
        }
        for(String s:equations){
            if(s.charAt(1) =='!'){
                char a = s.charAt(0);
                char b= s.charAt(3);
                int p1=find(parent,a-'a');
                int p2 = find(parent,b-'a');
                if(p1==p2) return false;
            }
        }
        return true;
    }
    public void union(int x,int y,int[] parent,int[] rank){
        int xp = find(parent,x);
        int yp = find(parent,y);
        if(xp == yp) return;
        if(rank[xp] < rank[yp]){
            parent[xp]= yp;
        }
        else if(rank[xp]>rank[yp]){
            parent[yp]= xp;
        }
        else{
            rank[xp]++;
            parent[yp]=xp;
        }
    }
    public int find(int[] parent,int x){
        if(x==parent[x]) return x;
        return parent[x]=find(parent,parent[x]);
    }
}