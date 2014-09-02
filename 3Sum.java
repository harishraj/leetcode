import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        /*
            quick sort num
            for i in [0..num.length-1]:
                for j in [i+1..num.length-1]:
                    dict.(i+j).add((i,j)) if doesn't exist
            for n in num:
                for (a,b) in dict.(-n):
                    result.add((n,a,b).sort!) if doesn't exist
            
            time O(n^2) space O(n^2)
        */
        Arrays.sort(num);
        HashMap<Integer,HashSet<Long>> dict = new HashMap<Integer,HashSet<Long>>();
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        for(int i=0; i<num.length; i++) {
            for(int j=i+1; j<num.length; j++) {
                int k = num[i] + num[j];
                HashSet<Long> vs = dict.containsKey(k) ? dict.get(k) : new HashSet<Long>();
                vs.add((((long)num[i])<<32) + (long)num[j]);
                dict.put(k, vs);
            }
        }
        for(int i = 0; i < num.length; i++) {
            int n = num[i];
            if(dict.containsKey(-n)) {
                for(Long v : dict.get(-n)) {
                    List<Integer> tl = new ArrayList<Integer>();
                    int a = (int)(v>>>32);
                    int b = (int)(v&0x00000000ffffffff);
                    if(n<=a){
                        tl.add(n); tl.add(a); tl.add(b);
                    }else if(a<n && n<b) {
                        tl.add(a); tl.add(n); tl.add(b);
                    }else {
                        tl.add(a); tl.add(b); tl.add(n);
                    }
                    set.add(tl);
                }
            }
        }
        return new ArrayList<List<Integer>>(set);
    }
}
