class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int r = mat.length;
        int c = mat[0].length;

        int[][] prefix = new int[r + 1][c + 1];

        // Build 2D prefix sum
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                prefix[i][j] = mat[i-1][j-1]
                             + prefix[i-1][j]
                             + prefix[i][j-1]
                             - prefix[i-1][j-1];
            }
        }

        int low = 0, high = Math.min(r, c);

        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (existsSquare(prefix, mid, threshold)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean existsSquare(int[][] prefix, int side, int threshold) {
        for (int i = side; i < prefix.length; i++) {
            for (int j = side; j < prefix[0].length; j++) {
                int sum = prefix[i][j]
                        - prefix[i - side][j]
                        - prefix[i][j - side]
                        + prefix[i - side][j - side];
                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}
