class Solution {
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> arr=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        generate(nums,0);
        return result;
    }
    public void generate(int[] nums,int i){
        if(i==nums.length){
            result.add(new ArrayList<>(arr));
            return;
        }
        generate(nums,i+1);
        arr.add(nums[i]);
        generate(nums,i+1);
        arr.remove(arr.size()-1);
        
    }
}