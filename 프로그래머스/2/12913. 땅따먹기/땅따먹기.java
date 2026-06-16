import java.util.*;

class Solution {
    int solution(int[][] land) {
        int[][] max = new int[land.length][4];
        for(int i=0; i<4; i++) {
            max[0][i] = land[0][i];
        }
        
        for(int i=1; i<max.length; i++) {
            for(int j=0; j<4; j++) {
                int temp = 0;
                for(int k=0; k<4; k++) {
                    if(j==k) continue;
                    temp = Math.max(temp, max[i-1][k]);
                }
                max[i][j] = temp + land[i][j];
            }
        }
        
        int answer = 0;
        for(int i=0; i<4; i++) {
            answer = Math.max(answer, max[max.length-1][i]);
        }
        
        return answer;
    }
}