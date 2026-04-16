class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        List<Integer> result = new ArrayList<>();
        for(int q: queries) {
            int num = nums[q];
            int ans = find(map.get(num), q, n);
            result.add(ans);
        }
        return result;
    }
    public int find(List<Integer> list, int q, int n) {
        int m = list.size();
        if (m == 1) {
            return -1;
        }
        int i = 0;
        int j = list.size() - 1;
        int target = -1;
        while(i <= j) {
            int mid = i + (j - i) / 2;
            if(list.get(mid) == q) {
                target = mid;
                break;
            }
            else if(list.get(mid) > q) {
                j = mid - 1;
            }
            else{
                i = mid + 1;
            }
        }
        int left = list.get((target - 1 + m) % m);
        int right = list.get((target + 1) % m);

        // distances
        int d1 = Math.abs(q - left);
        int d2 = Math.abs(q - right);

        // circular distance
        d1 = Math.min(d1, n - d1);
        d2 = Math.min(d2, n - d2);

        return Math.min(d1, d2);
    }
}