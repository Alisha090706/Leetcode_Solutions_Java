class Solution {
    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int answer = 0;
        for(int num : nums){
            int divisor = 2;
            int sum = 1 + num;
            for(int i = 2; i * i <= num; i++){
                if(num % i == 0){
                    int other = num / i;
                    if(num % i == 0){
                        if(other == i){
                            divisor += 1;
                            sum += i;
                        }
                        else{
                            divisor += 2;
                            sum += i + other;
                        }
                    }

                }
            }
            
            if(divisor == 4){
                answer += sum;
            }
        }
        return answer; 
    }
}