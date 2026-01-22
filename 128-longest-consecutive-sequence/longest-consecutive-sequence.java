class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int maxlen = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);

        for(int num : set){
            if(!set.contains(num - 1)){
                int len = 1;
                int curr = num;
                while(set.contains(curr + 1)){
                    len ++;
                    curr ++;
                }
                maxlen = Math.max(maxlen, len);
            }
        }
        return maxlen;
        
    }
}