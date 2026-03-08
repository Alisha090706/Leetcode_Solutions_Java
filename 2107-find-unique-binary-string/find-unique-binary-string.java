class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(String num:nums){
            set.add(Integer.parseInt(num,2));
        }
        for(int i=0;i<(int)Math.pow(2,nums.length);i++){
            if(!set.contains(i)){
                String binary = Integer.toBinaryString(i);
                return String.format("%" + nums.length + "s", binary).replace(' ', '0');
            }
        }
        return "";
    }
}