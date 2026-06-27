class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> map = new HashMap<>();
        int ones = 0;

        for (int num : nums) {
            if (num == 1) {
                ones++;
            } else {
                map.put((long) num, map.getOrDefault((long) num, 0) + 1);
            }
        }

        int ans = 0;

        // Handle all 1's separately
        if (ones > 0) {
            ans = (ones % 2 == 0) ? ones - 1 : ones;
        }

        Arrays.sort(nums);

        for (int num : nums) {
            if (num == 1) continue;

            long x = num;
            int len = 0;

            while (map.getOrDefault(x, 0) >= 2) {
                len += 2;
                x = x * x;
            }

            if (map.getOrDefault(x, 0) >= 1) {
                len++;
            } else {
                len--;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}