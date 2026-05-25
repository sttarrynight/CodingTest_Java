import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int[] div = new int[101];
        
        for(int i=0; i<arr.length; i++) {
            int cur = arr[i];
            int divNum = 2;
            Map<Integer,Integer> map = new HashMap<>();
            if(cur==1) continue;
            while(cur > 1) {
                if(cur%divNum==0) {
                    map.put(divNum, map.getOrDefault(divNum,0)+1);
                    cur /= divNum;
                } else divNum++;
            }
            for(int k : map.keySet()) {
                if(map.get(k) > div[k]) {
                    div[k] = map.get(k);
                }
            }
        }
        
        int answer = 1;
        
        for(int i=2; i<div.length; i++) {
            if(div[i]==0) continue;
            answer *= Math.pow(i,div[i]);
        }
        
        return answer;
    }
}