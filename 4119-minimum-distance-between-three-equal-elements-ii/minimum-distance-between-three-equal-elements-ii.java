class Solution {
    public int minimumDistance(int[] nums) {
        int n=nums.length;
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }
        int ans=Integer.MAX_VALUE;
        for(int key:map.keySet()){
            ArrayList<Integer> list=map.get(key);
            if(list.size()<3) continue;
            int i=0;
            while(i<list.size()-2){
                int dist=Math.abs(list.get(i)-list.get(i+1))+Math.abs(list.get(i+1)-list.get(i+2))+Math.abs(list.get(i+2)-list.get(i));
                ans=Math.min(dist,ans);
                i++;
            }
        }
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}