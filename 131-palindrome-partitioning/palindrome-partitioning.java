class Solution {
    List<List<String>> result = new ArrayList<>();
    int n;
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        n = s.length();
        // Approach 1 : Backtracking
        List<String> list = new ArrayList<>();
        // backtracking(s, 0, list);
         
        // Approach 2 
        dp = new boolean[n][n];

        for(int l=1;l<=n;l++){
            for(int i=0;i+l-1<n;i++){
                int j=i+l-1;
                if(i==j) dp[i][j]=true;
                else if(i+1==j){
                    dp[i][j]=s.charAt(i)==s.charAt(j);
                }
                else{
                    dp[i][j]=dp[i+1][j-1] && (s.charAt(i)==s.charAt(j));
                }
            }
        }

        solve(s,0,list);
        return result;

    }
    public void solve(String s,int i,List<String> list){
        if(i==n){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int j=i;j<n;j++){
            if(dp[i][j]){
                list.add(s.substring(i,j+1));
                solve(s,j+1,list);
                list.remove(list.size()-1);
            }
        }
    }
    // public void backtracking(String s, int i, List<String> list){
    //     if(i == n){
    //         result.add(new ArrayList<>(list));
    //         return;
    //     }
    //     for(int j=i;j<n;j++){
    //         if(palindrome(s.substring(i,j+1))){
    //             list.add(s.substring(i,j+1));
    //             backtracking(s,j+1,list);
    //             list.remove(list.size()-1);

    //         }
    //     }
    // }
    // public boolean palindrome(String s){
    //     int i=0;
    //     int j=s.length()-1;
    //     while(i<=j){
    //         if(s.charAt(i)!=s.charAt(j)) return false;
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }
}