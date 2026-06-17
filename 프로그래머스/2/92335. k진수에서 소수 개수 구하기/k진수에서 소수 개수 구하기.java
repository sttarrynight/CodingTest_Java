import java.util.*;

class Solution {
    
    private boolean isPrime(String str) {
        long num = Long.parseLong(str);
        if(num<=1) return false;
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i==0) {
                return false;
            }
        }
        return true;
    }
    
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            if(n==0) {
                break;
            }
            sb.append(n%k);
            n /= k;
        }
        
        String[] kBaseNum = sb.reverse().toString().split("0");
        
        int answer = 0;
        for(String num : kBaseNum) {
            if(num.equals("")) continue;
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
}