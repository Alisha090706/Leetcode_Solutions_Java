class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        for(int i = 0; i < 4; i++) {
            boolean match = true;
            for(int j = 0; j < 4; j++){
                if(b[j] == a[i]) {
                    match = true;
                    if((j - i) % 2 != 0) match = false;
                    else break;
                }
                else{
                    match = false;
                }
            }
            if(!match) return false;
        }
        return true;
    }
}