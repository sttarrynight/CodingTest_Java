import java.util.*;

class Solution {
    
    Map<String,Integer> comb;
    
    void combination(char[] order, int depth, int k, int start, StringBuilder sb) {
        if(depth == k) {
            String str = sb.toString();
            comb.put(str, comb.getOrDefault(str,0) + 1);
            return;
        }
        
        for(int i=start; i<order.length; i++) {
            sb.append(order[i]);
            combination(order, depth+1, k, i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answerList = new ArrayList<>();
        
        StringBuilder sb;
        
        for(int k : course) {
            comb = new HashMap<>();
            
            for(String order : orders) {
                char[] sortedOrder = order.toCharArray();
                Arrays.sort(sortedOrder);
                sb = new StringBuilder();
                combination(sortedOrder, 0, k, 0, sb);
            }
            
            int max = 2;
            for(int x : comb.values()) {
                if(x > max) {
                    max = x;
                }
            }
            
            for(String s : comb.keySet()) {
                int v = comb.get(s);
                if(v >= 2 && v == max) {
                    answerList.add(s);
                }
            }
        }
        
        Collections.sort(answerList);
        
        return answerList.toArray(new String[0]);
    }
}