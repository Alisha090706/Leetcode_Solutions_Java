
import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> {
            int sumA = digitSum(nums[a]);
            int sumB = digitSum(nums[b]);

            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }

            return Integer.compare(nums[a], nums[b]);
        });

        int[] target = new int[n];

        for (int i = 0; i < n; i++) {
            target[i] = nums[indices[i]];
        }

        // Find minimum swaps using cycle decomposition
        boolean[] visited = new boolean[n];
        int swaps = 0;

        // Map each original position to its destination
        for (int i = 0; i < n; i++) {
            if (visited[i] || indices[i] == i) {
                visited[i] = true;
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = indices[j];
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += cycleSize - 1;
            }
        }

        return swaps;
    }

    public int digitSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}