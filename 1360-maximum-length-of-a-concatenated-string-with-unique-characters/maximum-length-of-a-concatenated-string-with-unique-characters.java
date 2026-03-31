class Solution {
    int n;
    HashMap<String, Integer> map = new HashMap<>();
    public int maxLength(List<String> arr) {
        n = arr.size();

        return solve(arr, 0, new StringBuilder(), new HashSet<>());
    }
    public int solve(List<String> arr, int i, StringBuilder sb, HashSet<Character> set){
        if(i == n) return sb.length();

        if(map.containsKey(sb.toString())) return map.get(sb.toString());
        int len = sb.length();

        //case 1: not take
        int skip = solve(arr, i + 1, sb, set);

        //case 2: take
        char[] ch = arr.get(i).toCharArray();
        boolean unique = true;
        HashSet<Character> temp = new HashSet<>();
        for(char c: ch){
            if(set.contains(c) || temp.contains(c)){
                unique = false;
                break;
            }
            temp.add(c);
        }
        int take = 0;
        if(unique){
            sb.append(arr.get(i));
            for(char c: ch) set.add(c);
            take = solve(arr, i + 1, sb, set);
            for(char c: ch) set.remove(c);
            sb.setLength(len);
        }
        map.put(sb.toString(),Math.max(skip, take));
        return Math.max(skip, take);
    }
}