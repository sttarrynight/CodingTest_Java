import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Deque<int[]> queue = new ArrayDeque<>();
		
		int[] di = {0,0,-1,1};
		int[] dj = {-1,1,0,0};
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(board[i][j]==0) {
					board[i][j] = 1;
					queue.add(new int[] {i,j});
					while(!queue.isEmpty()) {
						int[] cur = queue.poll();
						for(int x=0; x<4; x++) {
							int ni = cur[0] + di[x];
							int nj = cur[1] + dj[x];
							
							if(ni<0) {
								ni = N-1;
							} else if(ni>N-1) {
								ni = 0;
							}
							
							if(nj<0) {
								nj = M-1;
							} else if(nj>M-1) {
								nj = 0;
							}
							
							if(board[ni][nj]==0) {
								board[ni][nj] = 1;
								queue.add(new int[] {ni,nj});
							}
						}
					}
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
