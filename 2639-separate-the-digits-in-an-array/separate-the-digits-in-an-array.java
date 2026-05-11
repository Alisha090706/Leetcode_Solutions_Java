class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            while(num > 0) {
                list.add(num % 10);
                num /= 10;
            }
        }
        Collections.reverse(list);
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}