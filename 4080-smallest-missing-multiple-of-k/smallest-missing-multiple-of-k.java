class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int min = 1;
        while(true) {
            if(min % k == 0 && !set.contains(min)) return min;
            min++;
        }
    }
}