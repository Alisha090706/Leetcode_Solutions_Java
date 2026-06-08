class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < pivot) {
                less.add(nums[i]);
            }
            else if( nums[i] == pivot) {
                equal.add(nums[i]);
            }
            else{
                greater.add(nums[i]);
            }
        }
        int[] result = new int[nums.length];
        int i = 0;
        for(int num : less) {
            result[i++] = num;
        }        
        for(int num : equal) {
            result[i++] = num;
        }        
        for(int num : greater) {
            result[i++] = num;
        }        
        return result;
    }
}