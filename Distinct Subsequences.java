import java.util.*;

public class Solution {
    public int numDistinct(String S, String T) {
        Map<List<Integer>,Integer> dp = new HashMap<List<Integer>,Integer>();
        return numDistinct0(S,0,T,0,dp);
    }
    private int numDistinct0(String S, int i, String T, int j, Map<List<Integer>,Integer> dp) {
        List<Integer> pair = new ArrayList<Integer>();
        pair.add(i);
        pair.add(j);
        if(dp.containsKey(pair)) return dp.get(pair);
        
        if(S.length()-i<T.length()-j) return 0;
        if(T.length()==j) return S.length()-i+1;
        
        int r1 = numDistinct0(S,i+1,T,j,dp);
        if(S.charAt(i)!=S.charAt(j)) dp.put(pair, r1);
        else {
            int r2 = numDistinct0(S,i+1,T,j+1,dp);
            dp.put(pair,r1+r2);
        }
        return dp.get(pair);
    }
}
