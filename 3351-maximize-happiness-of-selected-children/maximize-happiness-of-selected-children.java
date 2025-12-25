class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n=happiness.length;
        Arrays.sort(happiness);
        long kids=0;
        long sum=0;
        for(int i=n-1;i>=0;i--){
            sum+=happiness[i]-kids<0?0:happiness[i]-kids;
            kids++;
            k--;
            if(k==0)break;
        }
        return sum;
    }
}