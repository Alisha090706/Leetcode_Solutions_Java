class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        
        int maxlen = 1;
        for(int num : set){
            if(!set.contains(num -1)){
                int len = 1;
                int curr = num;

                while(set.contains(curr+1)){
                    curr++;
                    len++;
                }
                maxlen = Math.max(maxlen, len );
            }
        }
        return maxlen;
    }
}