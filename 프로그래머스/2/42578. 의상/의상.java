import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String,Integer> clothesMap = new HashMap<>();
        
        for(String[] str : clothes) {
            clothesMap.put(str[1], clothesMap.getOrDefault(str[1], 0) + 1);
        }
        
        int answer = 1;
        
        for(String category : clothesMap.keySet()) {
            answer *= clothesMap.get(category) + 1;
        }
        
        return answer - 1;
    }
}