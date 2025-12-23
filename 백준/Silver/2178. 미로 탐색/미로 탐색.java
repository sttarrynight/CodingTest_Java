import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] miro;
	static int N, M;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		miro = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split("");
			for(int j=0; j<M; j++) {
				miro[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		bfs();
	}

	private static void bfs() {
		Deque<int[]> queue = new ArrayDeque<>();
		int[] di = {0,0,1,-1};
		int[] dj = {-1,1,0,0};
		queue.add(new int[] {0,0});
		miro[0][0] = 2;
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			for(int x=0; x<4; x++) {
				int ni = cur[0] + di[x];
				int nj = cur[1] + dj[x];
				if(ni==N-1 && nj==M-1) {
					System.out.println(miro[cur[0]][cur[1]]);
					return;
				}
				if(ni < 0 || ni > N-1 || nj < 0 || nj > M-1) continue;
				if(miro[ni][nj]==1) {
					miro[ni][nj] = miro[cur[0]][cur[1]] + 1;
					queue.add(new int[] {ni,nj});
				}
			}
		}
	}
}