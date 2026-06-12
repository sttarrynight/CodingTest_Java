import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int answer = 0;
        int start = 0;
        int end = people.length-1;
        
        while(start<=end) {
            if(start==end) {
                answer++;
                break;
            }
            int diff = limit - people[end];
            if(diff >= people[start]) {
                start++;
            }
            answer++;
            end--;
        }
        
        return answer;
    }
}