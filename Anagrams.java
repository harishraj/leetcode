public class Solution {
    public List<String> anagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        for(int i=0; i<strs.length; i++) {
            String v = strs[i];
            String k = sort(v);
            List<String> vs = map.containsKey(k) ? map.get(k) : new ArrayList<String>();
            vs.add(v);
            map.put(k, vs);
        }
        List<String> r = new ArrayList<String>();
        for(String k : map.keySet()) {
            if(map.get(k).size()>r.size()) r = map.get(k);
        }
        return r.size()>1?r:new ArrayList<String>();
    }
    
    private String sort(String s) {
        if(s==null||s.length()<=1) return s;
        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        return String.valueOf(ca);
    }
}
