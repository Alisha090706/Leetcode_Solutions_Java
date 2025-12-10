class Solution {
    public int countPermutations(int[] complexity) {
        int n=complexity.length;
        long result=1;
        int MOD=1000000007;
        for(int i=1;i<n;i++){
            //if any complexity is less than or computer to complexity of computer "0" then we can never unlock all the computers
            if(complexity[i]<=complexity[0]) return 0;

            //else the answer is simply (n-1)!
            result = (result*i)%MOD;
        }
        return (int)result;
    }
}