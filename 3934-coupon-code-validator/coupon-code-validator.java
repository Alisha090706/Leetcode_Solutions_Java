class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> result = new ArrayList<>();

        // Required business line order
        String[] order ={"electronics", "grocery", "pharmacy", "restaurant"};

        // Map to store valid codes by business line
        Map<String, List<String>> map = new HashMap<>();
        for (String b:order) {
            map.put(b,new ArrayList<>());
        }

        int n=code.length;

        for (int i=0;i<n;i++) {
            if(!isActive[i]) continue;
            if(!map.containsKey(businessLine[i])) continue;
            if(!valid(code[i])) continue;
            map.get(businessLine[i]).add(code[i]);
        }

        // Collect result in required order
        for (String b:order) {
            List<String> list = map.get(b);
            Collections.sort(list); // sort codes lexicographically
            result.addAll(list);
        }

        return result;
    }

    public boolean valid(String s) {
        if (s.length()==0) return false;

        for (char c : s.toCharArray()) {
            if (!(c == '_' ||
                  (c >= 'a' && c <= 'z') ||
                  (c >= 'A' && c <= 'Z') ||
                  (c >= '0' && c <= '9'))) {
                return false;
            }
        }
        return true;
    }
}
