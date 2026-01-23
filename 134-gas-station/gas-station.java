class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        //gas[i] = amount of gas available
        // cost[i] = amount of gas needed to travel from station i to i + 1
        // basically -> + gas[i] - cost[i];
        // we need to reach at index from which we started.
        //if totalcost is more than total gas then return -1 because 
        //there would be no way we can return back without running out of gas
        int totalCost = 0;
        int totalGas = 0;
        
        //if at index i, gas runs out then between start to i there is no valid starting point

        //Greedy Approach
        for(int i = 0; i < n; i++){
            totalCost += cost[i];
            totalGas += gas[i];
        }
        if(totalCost > totalGas) return -1;

        int tank = 0;
        int result = -1;
        for(int i = 0; i < n ;i++){
            tank += gas[i] - cost[i];
            if(tank < 0){
                tank = 0;
                result = -1;
            }else{
                if(result == -1){
                    result = i;
                }
            }
        }
        return result;
        //Brute Force
        // for(int i = 0; i < n; i ++){
        //     int startingidx = i;
        //     int idx = (i + 1) % n;
        //     int tank = gas[i];
        //     while(idx != startingidx){
        //         int prev = idx == 0 ? n - 1 : idx -1;
        //         tank -= cost[prev];
        //         if(tank < 0) break;
        //         tank += gas[idx];
        //         idx = (idx + 1) % n;
        //     }
        //     int p = idx == 0 ? n - 1 : idx -1;
        //     tank -= cost[p];
        //     if(idx == startingidx && tank >= 0) return i;
        // }
 
        
    }
}