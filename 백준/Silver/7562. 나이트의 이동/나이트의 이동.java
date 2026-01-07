import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int L;
	static int[][] chess;
	
	static int[] di = {1,1,2,2,-1,-1,-2,-2};
	static int[] dj = {2,-2,1,-1,2,-2,1,-1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(N-->0) {
			L = Integer.parseInt(br.readLine());
			chess = new int[L][L];
			
			st = new StringTokenizer(br.readLine());
			int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			st = new StringTokenizer(br.readLine());
			int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			if(start[0]==end[0] && start[1]==end[1]) {
				sb.append(0).append("\n");
			} else {
				sb.append(bfs(start,end)).append("\n");
			}
		}
		
		System.out.println(sb);
	}

	private static int bfs(int[] start, int[] end) {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(start);
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int x=0; x<8; x++) {
				int ni = cur[0] + di[x];
				int nj = cur[1] + dj[x];
				
				if(ni==end[0] && nj==end[1]) {
					return chess[cur[0]][cur[1]]+1;
				}
				
				if(ni<0 || ni>L-1 || nj<0 || nj>L-1) continue;
				
				if(chess[ni][nj]==0) {
					chess[ni][nj] = chess[cur[0]][cur[1]] + 1;
					queue.add(new int[] {ni,nj});
				}
			}
		}
		return 0;
	}
}