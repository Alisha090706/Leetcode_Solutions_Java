class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (int num : nums) {
            int lenWithIncrement = dp.getOrDefault(num, 0) + 1;
            int lenWithoutIncrement = dp.getOrDefault(num - 1, 0) + 1;

            dp.put(num + 1, Math.max(dp.getOrDefault(num + 1, 0), lenWithIncrement));
            dp.put(num, Math.max(dp.getOrDefault(num, 0), lenWithoutIncrement));

            maxLen = Math.max(maxLen, Math.max(dp.get(num), dp.get(num + 1)));
        }

        return maxLen;
    }
}