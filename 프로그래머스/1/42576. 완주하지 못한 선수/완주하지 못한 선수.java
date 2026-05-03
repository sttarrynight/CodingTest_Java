import java.util.*;
import java.io.*;
import java.util.Map.Entry;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String str : participant){
            if(map.containsKey(str)){
               map.replace(str,map.get(str)+1); 
            } else {
                map.put(str,1);
            }
        }
        for(String str : completion){
            map.replace(str,map.get(str)-1);
        }
        String answer = "";
        for(Entry<String,Integer> e : map.entrySet()){
            if(e.getValue()>=1){
                answer = e.getKey();
                break;
            } else continue;
        }
        return answer;
    }
}