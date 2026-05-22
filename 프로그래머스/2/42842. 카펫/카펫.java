import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        HashSet<Integer> wSet = new HashSet<>();
        int all = brown + yellow;
        for(int i=3; i<=all/2; i++) {
            if(all%i==0) {
                if(wSet.contains(all/i)) break;
                wSet.add(all/i);
            }
        }
        
        int[] answer = new int[2];
        
        for(int w : wSet) {
            int h = all/w;
            int calcYellow = (h-2) * (w-2);
            if(calcYellow == yellow) {
                if(h > w) {
                    answer[0] = h;
                    answer[1] = w;
                    continue;
                }
                answer[0] = w;
                answer[1] = h;
            }
        }
        
        return answer;
    }
}