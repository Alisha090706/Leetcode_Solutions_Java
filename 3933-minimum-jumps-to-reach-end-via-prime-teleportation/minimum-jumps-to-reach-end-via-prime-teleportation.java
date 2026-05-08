class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;

        // stores all indices divisible by a prime
        Map<Integer, List<Integer>> map = new HashMap<>();

        // build teleport map
        for (int i = 0; i < n; i++) {

            int val = nums[i];

            // find all prime factors of nums[i]
            for (int p = 2; p * p <= val; p++) {

                if (val % p == 0) {

                    map.putIfAbsent(p, new ArrayList<>());
                    map.get(p).add(i);

                    while (val % p == 0) {
                        val /= p;
                    }
                }
            }

            // remaining prime factor
            if (val > 1) {
                map.putIfAbsent(val, new ArrayList<>());
                map.get(val).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int jumps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int i = q.poll();

                // reached end
                if (i == n - 1) {
                    return jumps;
                }

                // move right
                if (i + 1 < n && !visited[i + 1]) {
                    visited[i + 1] = true;
                    q.offer(i + 1);
                }

                // move left
                if (i - 1 >= 0 && !visited[i - 1]) {
                    visited[i - 1] = true;
                    q.offer(i - 1);
                }

                // prime teleport
                if (isPrime(nums[i])) {

                    int p = nums[i];

                    if (map.containsKey(p)) {

                        for (int next : map.get(p)) {

                            if (!visited[next]) {
                                visited[next] = true;
                                q.offer(next);
                            }
                        }

                        // very important optimization
                        map.remove(p);
                    }
                }
            }

            jumps++;
        }

        return -1;
    }
    private boolean isPrime(int num) {

        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}