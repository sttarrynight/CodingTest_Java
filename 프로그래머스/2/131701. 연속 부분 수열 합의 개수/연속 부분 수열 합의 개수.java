import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> sumSet = new HashSet<>();
        int[] sums = new int[elements.length];
        
        for(int i=0; i<elements.length; i++){
            int next = i;
            for(int j=0; j<elements.length; j++){
                if(next >= elements.length) next = 0;
                sums[j] += elements[next];
                sumSet.add(sums[j]);
                next++;
            }
        }
        
        int answer = sumSet.size();
        return answer;
    }
}