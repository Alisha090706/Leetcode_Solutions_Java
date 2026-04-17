class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int dist = Integer.MAX_VALUE;
        map.put(reverse(nums[0]),0);
        for (int i = 1; i < nums.length; i++) {
            int rev = reverse(nums[i]);
            if (map.containsKey(nums[i])) {
                dist=Math.min(dist,i-map.get(nums[i]));
            }
            map.put(rev,i);
        }

        return dist == Integer.MAX_VALUE ? -1 : dist;

    }
    public int reverse(int n) {
        int reverse = 0;
        while(n > 0) {
            reverse = reverse * 10 + n % 10;
            n = n / 10;
        }
        return reverse;
    }
}