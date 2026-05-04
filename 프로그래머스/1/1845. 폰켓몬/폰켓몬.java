import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int answer = map.size()>=nums.length/2?nums.length/2:map.size();
        return answer;
    }
}