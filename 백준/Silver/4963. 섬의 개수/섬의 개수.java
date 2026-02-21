import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int w,h;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) break;
			
			int[][] map = new int[h][w];
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Deque<int[]> queue = new ArrayDeque<>();
			
			int[] di = {-1,-1,-1,1,1,1,0,0};
			int[] dj = {-1,0,1,-1,0,1,-1,1};
			int cnt = 0;
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j]==1) {
						map[i][j] = -1;
						queue.add(new int[] {i,j});
						while(!queue.isEmpty()) {
							int[] cur = queue.poll();
							for(int x=0; x<8; x++) {
								int ni = cur[0] + di[x];
								int nj = cur[1] + dj[x];
								
								if(ni<0 || ni>h-1 || nj<0 || nj>w-1) continue;
								
								if(map[ni][nj]==1) {
									map[ni][nj] = -1;
									queue.add(new int[] {ni,nj});
								}
							}
						}
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
