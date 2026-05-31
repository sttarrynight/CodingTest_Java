import java.util.*;

class Solution {
    
    public static boolean[] visited;
    
    public static void dfs(int net, int[][] coms) {
        for(int i=0; i<coms[net].length; i++) {
            if(i==net) continue;
            if(!visited[i] && coms[net][i]==1) {
                visited[i] = true;
                dfs(i,coms);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i,computers);
                answer++;
            }
        }
        return answer;
    }
}