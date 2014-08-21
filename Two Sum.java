// Two Sum

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(numbers.length);
        for(int i = 0; i < numbers.length; i++) {
            map.put(i, numbers[i]);
        }
        for(int i = 0; i < numbers.length; i++) {
            if(map.containsValue(target-numbers[i])) {
                for(int j=i+1; j<numbers.length; j++) {
                    if(numbers[i]+numbers[j]==target) {
                        return new int[]{i+1, j+1};
                    }
                }
            }
        }
        return new int[]{-1,-1};
    }
}
