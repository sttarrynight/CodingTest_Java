import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        int[] di = {0,0,-1,1};
        int[] dj = {-1,1,0,0};
        queue.add(new int[] {0,0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int x=0; x<4; x++){
                int ni = cur[0] + di[x];
                int nj = cur[1] + dj[x];
                if(ni<0 || ni>n-1 || nj<0 || nj>m-1 || maps[ni][nj]==0) continue;
                if(maps[ni][nj]==1){
                    maps[ni][nj] += maps[cur[0]][cur[1]];
                    queue.add(new int[] {ni,nj});
                }
            }
        }
        int answer = maps[n-1][m-1]==1 ? -1 : maps[n-1][m-1];
        return answer;
    }
}