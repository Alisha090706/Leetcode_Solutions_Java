class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int sum = 0;
        int i = 0;
        int j = 0;
        int result = 0;
        while(j < k){
            sum += arr[j];
            j++;
        }
        if((double)(sum / k) >= threshold) result++;

        while(j < n){
            sum += arr[j];
            sum -= arr[i];
            if((double)(sum / k) >= threshold) result++;
            i++;
            j++;
        }
        return result;
    }
}