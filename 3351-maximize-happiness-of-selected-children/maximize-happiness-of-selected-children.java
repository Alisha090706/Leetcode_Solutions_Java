class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n=happiness.length;
        Arrays.sort(happiness);
        long kids=0;
        long sum=0;
        for(int i=n-1;k-->0;i--){
            long curr=happiness[i]-kids;
            if(curr<0) break;
            sum+=curr;
            kids++;

        }
        return sum;
    }
}