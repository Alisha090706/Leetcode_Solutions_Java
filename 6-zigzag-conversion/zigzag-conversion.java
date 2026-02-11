class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int n = s.length();
        ArrayList<ArrayList<Character>> arr = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            arr.add(new ArrayList<>());
        }
        int i = 0;
        int j = 0;
        boolean down = true;
        while(i < n){
            char c = s.charAt(i);
            arr.get(j).add(c);
            if(down){
                if(j == numRows - 1){
                    down = false;
                    j--;
                }
                else j++;
            }
            else{
                if(j == 0){
                    down = true;
                    j++;
                }
                else j--;
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for(ArrayList<Character> list: arr){
            for(char c: list){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}