class Solution {
    public int totalWaviness(int num1, int num2) {
        int sum=0;
        for(int i=num1;i<=num2;i++){
            sum+=peaksAndValleys(String.valueOf(i));
        }
        return sum;
    }
    public int peaksAndValleys(String s){
        int n=s.length();
        if(s.length()<3)return 0;
        int num=0;
        for(int i=1;i<n-1;i++){
            if((s.charAt(i)>s.charAt(i-1)&&s.charAt(i)>s.charAt(i+1)
               || (s.charAt(i)<s.charAt(i-1) &&s.charAt(i)<s.charAt(i+1)))){
                num++;
               }
        }
        return num;
    }
}