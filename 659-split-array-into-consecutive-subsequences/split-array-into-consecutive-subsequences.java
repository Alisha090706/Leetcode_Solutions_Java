class Solution {
    public boolean isPossible(int[] nums) {
        int n = nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> need = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        //let us consider a number n. If there is a sequence ending at n - 1 then extend it otherwise start new sequence.
        //if multiple subsequences end with n - 1 then choose the shortest one.
        for(int num:nums){
            if(map.get(num) == 0) continue;
            //Case 1: Extend the existing subsequence.
            if(need.getOrDefault(num, 0) > 0){
                need.put(num, need.get(num) - 1);
                need.put(num + 1, need.getOrDefault(num+1,0)+1);
                map.put(num,map.get(num) - 1);
            }
            //Case 2: Start a new subsequence
            else if(map.getOrDefault(num + 1, 0) > 0 && map.getOrDefault(num+2,0)>0){
                map.put(num,map.get(num) - 1);
                map.put(num + 1, map.get(num + 1)-1);
                map.put(num + 2, map.get(num + 2)-1);

                need.put(num+3,need.getOrDefault(num+3,0)+1);
            }

            //case 3: Impossible
            else return false;
        }
        return true;
    }
}