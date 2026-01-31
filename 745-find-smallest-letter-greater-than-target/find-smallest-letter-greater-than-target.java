class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        Arrays.sort(letters);
        int n = letters.length;
        int i = 0;
        int j = n-1;
        int ans = 0;
        while(i <= j){
            int mid = i + (j-i)/2;
            if(letters[mid] <= target){
                i = mid + 1;
            }
            else{
                ans = mid;
                j  = mid - 1;
            }
        }
        return letters[ans];
    }
}