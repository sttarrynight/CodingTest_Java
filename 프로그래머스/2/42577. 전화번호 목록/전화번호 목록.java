import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        boolean answer = true;
        for(int i=0; i<phone_book.length-1; i++){
            int len = phone_book[i].length();
            if(phone_book[i+1].length()<len) continue;
            if(phone_book[i].equals(phone_book[i+1].substring(0,len))){
                answer = false;
                break;
            }
        }
        return answer;
    }
}