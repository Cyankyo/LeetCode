package week481.Q1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public long minCost(String s, int[] cost) {
        Map<Character, Long> costMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (costMap.containsKey(c)) {
                costMap.put(c, cost[i] + costMap.get(c));
            } else {
                costMap.put(c, (long) cost[i]);
            }
        }
        long max=0;
        long sum=0;
        for (char c:costMap.keySet()){
            sum+=costMap.get(c);
            max=Math.max(max,costMap.get(c));
        }
        return sum-max;
    }
}