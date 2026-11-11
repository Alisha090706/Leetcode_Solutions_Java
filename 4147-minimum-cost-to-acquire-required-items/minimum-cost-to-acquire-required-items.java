class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long totalcost = 0L; 
        if(cost1 + cost2 < costBoth) return 1L * need1 * cost1 + 1L * need2 * cost2;
        int count3 = Math.min(need1, need2);
        totalcost = 1L * count3 * costBoth;
        need1 -= count3;
        need2 -= count3;
        if(need1 > 0) {
            totalcost += 1L * need1 * Math.min(cost1, costBoth);
        }
        else if(need2 > 0) {
            totalcost += 1L * need2 * Math.min(cost2, costBoth);
        }
        return totalcost;
    }
}