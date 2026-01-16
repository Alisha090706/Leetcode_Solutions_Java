class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int MOD = 1000000007;

        HashSet<Integer> horizontal = new HashSet<>();
        HashSet<Integer> vertical = new HashSet<>();

        List<Integer> h = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        h.add(1);
        h.add(m);
        for(int num:hFences){
            h.add(num);
        }
        
        v.add(1);
        v.add(n);
        for(int num:vFences){
            v.add(num);
        }
        Collections.sort(h);
        Collections.sort(v);
        for(int i = 0; i< h.size();i++){
            for(int j =i+1;j<h.size();j++){
                horizontal.add(h.get(j)-h.get(i));
            }
        }
        for(int i = 0; i< v.size();i++){
            for(int j =i+1;j<v.size();j++){
                vertical.add(v.get(j)-v.get(i));
            }
        }
        long result = -1;
        for(int num:horizontal){
            if(vertical.contains(num)){
                result = Math.max(result, (long)num*num);
            }
        }
        return result == -1? -1 :(int) (result%MOD);

    }
}