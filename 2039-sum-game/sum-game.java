class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        char[] arr = num.toCharArray();
        
        int count1 = 0;
        int count2 = 0;
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < n / 2; i++) {
            if(arr[i] == '?') count1 ++;
            else sum1 += (arr[i] - '0');
        }
        for(int i = n / 2; i < n; i++) {
            if(arr[i] == '?') count2++;
            else sum2 += (arr[i] - '0');
        }

        int diff = sum1 - sum2;
        int countDiff = count2 - count1;
        return diff * 2 != 9 * countDiff;
    }
}