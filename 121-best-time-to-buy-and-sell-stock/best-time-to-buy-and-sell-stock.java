class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int curr = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < n ;i++){
            curr = Math.min(curr, prices[i]);
            profit = Math.max(profit, prices[i] - curr);
        }
        return profit;
    }
}