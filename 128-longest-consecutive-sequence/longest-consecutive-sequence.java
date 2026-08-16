class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        for(int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int len = 0;

                while (set.contains(current)) {
                    len++;
                    current++;
                }

                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}