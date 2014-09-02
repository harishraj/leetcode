import java.util.*;

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // time O(n^2log(n)) space O(log(n))
        Arrays.sort(num);
        int diff = 0x7fffffff;
        for(int i = 0; i < num.length; i++) {
            for(int j = i+1; j < num.length; j++) {
                int t = target - num[i] - num[j];
                int k = Arrays.binarySearch(num, j+1, num.length, t);
                if(k>=0) return target;
                else {
                    if((~k)<num.length && Math.abs(target-num[~k]) < Math.abs(diff)) diff = target-num[~k];
                    if((~k)>0 && (~k)<=num.length && Math.abs(target-num[(~k)-1]) < Math.abs(diff)) diff = target - num[(~k)-1];
                }
            }
        }
        return target - diff;
    }
}
