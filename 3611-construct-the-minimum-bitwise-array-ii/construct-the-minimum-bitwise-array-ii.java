class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            int num = nums.get(i);
            if(num == 2) {
                result[i] = -1;
                continue;
            }
            int prev = 0;
            boolean found = false;
            for(int j = 0; j <32; j++){
                if((num & (1 << j)) > 0) continue;
                prev = j - 1;
                result[i] = (num ^ (1 << prev));
                found = true;
                break;
            }
            if(!found) result[i] = -1;
        }
        return result;
    }
}