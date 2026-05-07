import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Deque<int[]> queue = new ArrayDeque<>();
        int[] di = {0,0,-1,1};
        int[] dj = {-1,1,0,0};
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];
        
        queue.add(new int[] {0,0});
        visited[0][0] = true;
        dist[0][0] = 1;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int x=0; x<4; x++){
                int ni = cur[0] + di[x];
                int nj = cur[1] + dj[x];
                if(ni<0 || ni>=n || nj<0 || nj>=m) continue;
                if(maps[ni][nj]==0 || visited[ni][nj]) continue;
                visited[ni][nj] = true;
                dist[ni][nj] = dist[cur[0]][cur[1]] + 1;
                queue.add(new int[] {ni,nj});
            }
        }
        int answer = visited[n-1][m-1] ? dist[n-1][m-1] : -1;
        return answer;
    }
}