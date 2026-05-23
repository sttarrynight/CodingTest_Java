import java.util.*;

class Solution {
    
    public static List<Integer>[] adj;
    public static boolean[] visited;
    public static int N;
    
    public static int checkNodes(int node) {
        visited = new boolean[N+1];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        visited[node] = true;
        int cnt = 1;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int c : adj[cur]) {
                if(!visited[c]) {
                    cnt++;
                    visited[c] = true;
                    queue.add(c);
                }
            }
        }
        return cnt;
    }
    
    public int solution(int n, int[][] wires) {
        
        int answer = 100000;
        N = n;
        
        for(int i=0; i<wires.length; i++) {
            int node1 = wires[i][0];
            int node2 = wires[i][1];
            adj = new ArrayList[n+1];
            for(int j=1; j<=n; j++) {
                adj[j] = new ArrayList<>();
            }
            for(int k=0; k<wires.length; k++) {
                if(k==i) continue;
                int e = wires[k][0];
                int v = wires[k][1];
                adj[e].add(v);
                adj[v].add(e);
            }
            if(Math.abs(checkNodes(node1)-checkNodes(node2)) < answer) {
                answer = Math.abs(checkNodes(node1)-checkNodes(node2));
            }
        }
        
        return answer;
    }
}