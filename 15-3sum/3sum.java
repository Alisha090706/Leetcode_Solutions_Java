class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        //creating a result arraylist
        List<List<Integer>> result = new ArrayList<>();
        
        //sorting the array as we only need to check in the array after the index i.
        Arrays.sort(nums);

        //We can convert 3 sum to 2 sum -> nums[i] + nums[j] + nums[k] = 0;
        // nums[i] + nums[j] = -nums[k] -> -nums[k] is the target here.

        //We will require a set to ensure that no triplet is repeated again due to duplicates.
        HashSet<List<Integer>> set = new HashSet<>();

        for(int k = 0; k < n - 2; k++){
            //checking if the curr element is already processed or not. 
            // if already processed we can just skip it.
            if(k > 0 && nums[k] == nums[k - 1]) continue;

            int num1 = nums[k];
            int target = -num1;

            int i = k + 1;
            int j = n - 1;

            List<List<Integer>> doublets = twoSum(nums, i, j, target);

            for(List<Integer> doublet : doublets){
                List<Integer> triplet = new ArrayList<>();
                triplet.add(num1);
                triplet.addAll(doublet);
                if(!set.contains(triplet)){
                    result.add(triplet);
                    set.add(triplet);
                }
            }
        }
        return result;
    }
    public List<List<Integer>> twoSum(int[] nums,int i ,int j, int target){
        List<List<Integer>> doublet = new ArrayList<>();
        
        while(i < j){
            int num1 = nums[i];
            int num2 = nums[j];
            if(num1 + num2 == target){
                List<Integer> doub = new ArrayList<>();
                doub.add(num1);
                doub.add(num2);
                doublet.add(doub);
                i++;
                j--;
            }
            else if(num1 + num2 < target){
                i++;
            }
            else{
                j--;
            }
        }
        return doublet;
    }
}