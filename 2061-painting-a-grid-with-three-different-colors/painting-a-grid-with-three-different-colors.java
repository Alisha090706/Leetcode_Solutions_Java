class Solution {
    ArrayList<String> states = new ArrayList<>();
    int MOD = 1000000007;
    char[] colors = {'R','G','B'};
    int[][] dp;
    int size;
    public int colorTheGrid(int m, int n) {
        int result = 0;

        for(int i = 0; i < 3; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(colors[i]);
            colorstate(i,sb,m);
        }
        size = states.size();
        dp=new int[n][size];
        for(int[] row:dp) Arrays.fill(row,-1);
        for(int i =0;i<size;i++){
            result = (result + solve(n-1,i,m))%MOD;
        }

        return result;
    }
    public int solve(int n,int prev,int m){
        if(n==0) return 1;

        if(dp[n][prev]!=-1) return dp[n][prev];

        String last = states.get(prev);
        int result = 0;

        for(int i=0;i<size;i++){
            if(i==prev) continue;
            String curr=states.get(i);
            boolean conflict=false;
            for(int j=0;j<m;j++){
                if(last.charAt(j)==curr.charAt(j)){
                    conflict=true;
                    break;
                }
            }
            if(!conflict){
                result = (result + solve(n-1,i,m)) % MOD;
            }
        }

        return dp[n][prev] = result;

    }
    public void colorstate(int prev,StringBuilder sb,int n){
        if(sb.length()==n){
            states.add(sb.toString());
            return;
        }

        for(int i=0;i<3;i++){
            if(i==prev) continue;
            sb.append(colors[i]);
            colorstate(i,sb,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}