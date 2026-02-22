class Solution {
    public int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        int size = s.length();
        int max = 0;
        int i = 0;
        while(i < size && s.charAt(i) != '1'){
            i++;
        }
        int j = i;
        while(j < size){
            if(s.charAt(j) == '1'){
                max = Math.max(max, j - i);
                i = j;
            }
            j++;
        }
        return max;
    }
}