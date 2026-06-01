import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0,1000001};
        
        int start = 0;
        int end = 0;
        int sum = 0;
        
        while(true) {
            if(sum >= k) {
                if(sum == k && end - 1 - start < answer[1] - answer[0]) {
                    answer[1] = end - 1;
                    answer[0] = start;
                }
                sum -= sequence[start++];
            } else {
                if(end == sequence.length) break;
                sum += sequence[end++];
            }
        }
        
        return answer;
    }
}