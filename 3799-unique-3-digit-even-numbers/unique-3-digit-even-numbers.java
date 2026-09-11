class Solution {
    HashSet<Integer> set = new HashSet<>();
    public int totalNumbers(int[] digits) {
        boolean[] used = new boolean[digits.length];

        solve(digits, used, 0, 0);

        return set.size();
    }
    public void solve(int[] d, boolean[] used, int num, int len) {
        if(len == 3) {
            if(num % 2 == 0) set.add(num);
            return;
        }
        for (int i = 0; i < d.length; i++) {
            if (used[i]) continue;

            if (len == 0 && d[i] == 0) continue;
            used[i] = true;
            solve(
                d,
                used,
                num * 10 + d[i],
                len + 1
            );
            used[i] = false;
        }
    }
}