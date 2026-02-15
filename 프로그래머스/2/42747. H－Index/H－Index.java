import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : citations){
            pq.add(i);
        }
        
        int answer = -1;
        int now = 0;
        
        while(!pq.isEmpty()){
            if(pq.size()>=now){
                answer = now;
            } else{
                break;
            }
            
            while(!pq.isEmpty() && pq.peek()<=now){
                pq.poll();
            }
            now++;
        }
        
        return answer;
    }
}