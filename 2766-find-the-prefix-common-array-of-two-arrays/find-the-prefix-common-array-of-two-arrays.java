class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] c = new int[n];
        for(int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            int count = 0;
            for(int j = 0; j <= i; j++) {
                if(!set.contains(A[j])) {
                    set.add(A[j]);
                }
                else {
                    count++;
                }

                if(!set.contains(B[j])) {
                    set.add(B[j]);
                }
                else count++;
            }
            c[i] = count;
        }
        return c;
    }
}