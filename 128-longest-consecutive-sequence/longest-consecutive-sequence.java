class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        TreeSet<Integer> set = new TreeSet<>();
        for(int num: nums){
            set.add(num);
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        int len = 1;
        int maxlen = 1;
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) == list.get(i-1) + 1){
                len++;
                maxlen = Math.max(maxlen, len);
            }
            else{
                len = 1;
            }
        }
        return maxlen;
    }
}