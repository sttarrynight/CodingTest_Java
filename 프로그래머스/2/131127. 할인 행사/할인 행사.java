import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String,Integer> wantMap = new HashMap<>();
        Map<String,Integer> discountMap = new HashMap<>();
        
        for(int i=0; i<want.length; i++) {
            wantMap.put(want[i],number[i]);
        }
        
        for(int i=0; i<10; i++) {
            discountMap.put(discount[i],discountMap.getOrDefault(discount[i],0)+1);
        }
        
        int answer = 0;
        
        for(int i=0; i<=discount.length-10; i++) {
            boolean joinable = true;
            for(String key : wantMap.keySet()) {
                if(!discountMap.containsKey(key) || wantMap.get(key) > discountMap.get(key)) {
                    joinable = false;
                    break;
                }
            }
            if(joinable) answer++;
            if(i==discount.length-10) break;
            discountMap.replace(discount[i],discountMap.get(discount[i])-1);
            if(discountMap.containsKey(discount[i+10])) {
                discountMap.replace(discount[i+10],discountMap.get(discount[i+10])+1);
            } else {
                discountMap.put(discount[i+10],1);
            }
        }
        
        return answer;
    }
}