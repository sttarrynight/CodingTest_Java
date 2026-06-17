import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<String> stack = new ArrayDeque<>();
        String[] nums = number.split("");
        stack.push(nums[0]);
        
        for(int i=1; i<number.length(); i++) {
            int now = Integer.parseInt(nums[i]);
            int top = Integer.parseInt(stack.peek());
            while(now > top && k > 0) {
                stack.pop();
                k--;
                if(stack.isEmpty()) break;
                top = Integer.parseInt(stack.peek());
            }
            stack.push(nums[i]);
        }
        
        while(k-- > 0) {
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        
        return sb.toString();
    }
}