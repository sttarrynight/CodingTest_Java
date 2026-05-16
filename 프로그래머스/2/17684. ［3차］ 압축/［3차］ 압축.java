import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String,Integer> dict = new HashMap<>();
		
        StringBuilder sb;
		char ch = 'A';
		
		for(int i=1; i<=26; i++) {
			sb = new StringBuilder();
			sb.append(ch);
			dict.put(sb.toString(), i);
			ch++;
		}
        
        ArrayList<Integer> answerList = new ArrayList<>();
        
        int left = 0;
        int nextVal = 27;
        
        while(left<msg.length()){
            String w = "";
            int c = left;
            
            while(c < msg.length() && dict.containsKey(msg.substring(left,c + 1))){
                c++;
            }
            
            w = msg.substring(left, c);
            answerList.add(dict.get(w));
            
            if(c < msg.length()){
                String wc = msg.substring(left, c+1);
                dict.put(wc, nextVal++);
            }
            
            left = c;
        }
        
        int[] answer = new int[answerList.size()];
        
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}