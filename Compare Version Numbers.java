import java.util.ArrayList;

public class Solution {
    public int compareVersion(String version1, String version2) {
        ArrayList<Integer> al1 = s2a(version1);
        ArrayList<Integer> al2 = s2a(version2);
        int l = Math.min(al1.size(), al2.size());
        for(int i=0; i<l; i++) {
            if(al1.get(i)>al2.get(i)) return 1;
            else if(al1.get(i)<al2.get(i)) return -1;
        }
        if(al1.size()>al2.size()) return 1;
        else if(al1.size()<al2.size()) return -1;
        else return 0;
    }
    
    private ArrayList<Integer> s2a(String version) {
        ArrayList<Integer> retval = new ArrayList<Integer>();
        for(String s : version.split(".")) {
            retval.add(Integer.valueOf(s));
        }
        return retval;
    }
}
