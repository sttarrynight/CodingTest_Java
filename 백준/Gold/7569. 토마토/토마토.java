import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int M;
	static int N;
	static int H;
	static int[][][] tomato;
	
	static int[] di = {0,0,0,0,-1,1};
	static int[] dj = {0,0,-1,1,0,0};
	static int[] dk = {-1,1,0,0,0,0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		tomato = new int[H][N][M];
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<M; k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(tomato[i][j][k]==1) {
						bfs(i,j,k);
					}
				}
			}
		}
		
		int max = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(tomato[i][j][k]==0) {
						System.out.println(-1);
						return;
					}
					
					if(tomato[i][j][k] > max) {
						max = tomato[i][j][k];
					}
				}
			}
		}
		
		System.out.println(max-1);
	}

	private static void bfs(int i, int j, int k) {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {i,j,k});
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int x=0; x<6; x++) {
				int ni = cur[0] + di[x];
				int nj = cur[1] + dj[x];
				int nk = cur[2] + dk[x];
				
				if(ni < 0 || ni > H-1 || nj < 0 || nj > N-1 || nk < 0 || nk > M-1) continue;
				
				if(tomato[ni][nj][nk]==0 || (tomato[ni][nj][nk]>1 && tomato[ni][nj][nk]>tomato[cur[0]][cur[1]][cur[2]] + 1)) {
					tomato[ni][nj][nk] = tomato[cur[0]][cur[1]][cur[2]] + 1;
					queue.add(new int[] {ni,nj,nk});
				}
			}
		}
	}
}