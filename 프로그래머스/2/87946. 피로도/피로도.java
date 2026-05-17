import java.util.*;

class Solution {
    
    public static boolean[] visited;
    public static int max = -1;
    
    public static void dfs(int k, int[][] dungeons, int depth) {
        if(depth == dungeons.length){
            max = Math.max(depth,max);
            return;
        }
        
        for(int i=0; i<dungeons.length; i++){
            if(visited[i]) continue;
            if(k<dungeons[i][0]) {
                max = Math.max(depth,max);
                continue;
            }
            visited[i] = true;
            dfs(k-dungeons[i][1], dungeons, depth+1);
            visited[i] = false;
        }
        return;
    }
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        int answer = -1;
        
        dfs(k,dungeons,0);
        
        answer = max;
        return answer;
    }
}