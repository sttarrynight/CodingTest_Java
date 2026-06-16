import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int N = triangle.length;
        int M = triangle[N-1].length;
        int[][] dp = new int[N][M];
        
        dp[0][0] = triangle[0][0];
        int max = dp[0][0];
        
        for(int i=1; i<N; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                if(j==0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if (j==triangle[i].length-1) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        
        return max;
    }
}