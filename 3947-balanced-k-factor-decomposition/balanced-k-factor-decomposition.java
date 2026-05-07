class Solution {
    int[] result;
    int min = Integer.MAX_VALUE;
    int N;
    public int[] minDifference(int n, int k) {
        N = n;
        result = new int[k];
        solve(n, k, new ArrayList<>(),1);
        return result;
    }
    public void solve(int n, int k, ArrayList<Integer> list, int prod) {
        if(list.size() == k) {
            if(prod != N) return;
            int dif = find(list);
            if(dif < min) {
                min = dif;
                for(int i = 0; i < k; i++) {
                    result[i] = list.get(i);
                }
            }
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                list.add(i);
                solve(n / i, k, list, prod * i);
                list.remove(list.size() - 1);
            }
        }
    }
    public int find(ArrayList<Integer> list) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++) {
            min = Math.min(min, list.get(i));
            max = Math.max(max, list.get(i));
        }
        return max - min;
    }
}