class Solution {
    public char findKthBit(int n, int k) {
        String s = "0";
        for(int i = 2; i <= n; i++){
            s = s + "1" + revinv(s);
        }
        return s.charAt(k-1);
    }
    public String revinv(String s){
        int n = s.length();
        char[] arr = s.toCharArray();
        for(int k = 0; k < n; k++){
            if(arr[k] == '0') arr[k] = '1';
            else arr[k] = '0';
        }
        int i = 0;
        int j = n - 1;
        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
        
    }
}