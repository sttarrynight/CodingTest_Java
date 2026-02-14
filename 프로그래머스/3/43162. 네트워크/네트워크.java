import java.util.*;
import java.io.*;

class Solution {
    
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int cnt;
    
    public int solution(int n, int[][] computers) {
        
        adj = new ArrayList[n];
        
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j && computers[i][j]==1){
                    adj[i].add(j);
                }
            }
        }
        
        visited = new boolean[n];
        cnt = 0;
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i);
                cnt++;
            }
        }
        
        int answer = cnt;
        return answer;
    }
    
    private static void dfs(int i){
        visited[i] = true;
        for(int v : adj[i]){
            if(!visited[v]){
                visited[v] = true;
                dfs(v);
            }
        }
    }
}