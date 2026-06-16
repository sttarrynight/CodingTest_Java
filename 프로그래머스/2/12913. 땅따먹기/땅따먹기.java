import java.util.*;

class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        for(int i=0; i<4; i++) {
            dp[0][i] = land[0][i];
        }
        
        for(int i=1; i<dp.length; i++) {
            for(int j=0; j<4; j++) {
                int max = 0;
                for(int k=0; k<4; k++) {
                    if(j==k) continue;
                    max = Math.max(max, dp[i-1][k]);
                }
                dp[i][j] = max + land[i][j];
            }
        }
        
        int answer = 0;
        for(int i=0; i<4; i++) {
            answer = Math.max(answer, dp[dp.length-1][i]);
        }
        
        return answer;
    }
}