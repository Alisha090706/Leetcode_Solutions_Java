class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        ArrayList<Long> arr = new ArrayList<>();
        long max = (long) nums[0];
        arr.add(max);
        for(int i = 1; i < n; i++) {
            max = Math.max(max, (long) nums[i]);
            long ans = gcd(max, (long) nums[i]);
            arr.add(ans);
        }
        Collections.sort(arr);
        long sum = 0L;
        int i = 0;
        int j = arr.size() - 1;
        while(i < j) {
            long ans = gcd(arr.get(i), arr.get(j));
            sum += ans;
            i++;
            j--;
        }
        return sum;
    }
    public long gcd(long a, long b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }
}