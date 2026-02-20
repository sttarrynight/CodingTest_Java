import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static char[][] rgb;
	static boolean[][] visited;
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		rgb = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String st = br.readLine();
			for(int j=0; j<N; j++) {
				rgb[i][j] = st.charAt(j);
			}
		}
		
		Deque<int[]> queue = new ArrayDeque<>();
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					queue.add(new int[] {i,j});
					while(!queue.isEmpty()) {
						int[] cur = queue.poll();
						for(int x=0; x<4; x++) {
							int ni = cur[0] + di[x];
							int nj = cur[1] + dj[x];
							
							if(ni<0 || ni>N-1 || nj<0 || nj>N-1) continue;
							
							if(!visited[ni][nj] && rgb[ni][nj]==rgb[i][j]) {
								visited[ni][nj] = true;
								queue.add(new int[] {ni,nj});
							}
						}
					}
					cnt++;
				}
			}
		}
		
		sb.append(cnt).append(" ");
		
		cnt = 0;
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					queue.add(new int[] {i,j});
					while(!queue.isEmpty()) {
						int[] cur = queue.poll();
						for(int x=0; x<4; x++) {
							int ni = cur[0] + di[x];
							int nj = cur[1] + dj[x];
							
							if(ni<0 || ni>N-1 || nj<0 || nj>N-1) continue;
							
							if(!visited[ni][nj]) {
								if(rgb[i][j] != 'B') {
									if(rgb[ni][nj]=='R' || rgb[ni][nj]=='G') {
										visited[ni][nj] = true;
										queue.add(new int[] {ni,nj});
									}
								} else {
									if(rgb[ni][nj]=='B') {
										visited[ni][nj] = true;
										queue.add(new int[] {ni,nj});
									}
								}
							}
						}
					}
					cnt++;
				}
			}
		}
		
		sb.append(cnt);
		System.out.println(sb);
	}

}
