class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;

        int step_1 = 1;
        int step_2 = 2;
        
        for(int stair = 3; stair <= n; stair ++) {
            int nextStep = step_1 + step_2;
            step_1 = step_2;
            step_2 = nextStep;
        }
        return step_2;
    }
}