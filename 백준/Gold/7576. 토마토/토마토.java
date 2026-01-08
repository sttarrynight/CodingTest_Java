import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][] tomato;
	
	static int[] di = {1,-1,0,0};
	static int[] dj = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		tomato = new int[N][M];
		List<int[]> oneTomatos = new ArrayList<>();
		
		boolean isAllOne = true; 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				tomato[i][j] = num;
				if(num==1) {
					oneTomatos.add(new int[] {i,j});
				}
				if(num==0) {
					isAllOne = false;
				}
			}
		}
		
		if(isAllOne) {
			System.out.println(0);
			return;
		}
		
		bfs(oneTomatos);
		
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int num = tomato[i][j];
				if(num==0) {
					System.out.println(-1);
					return;
				}
				if(num > max) {
					max = num;
				}
			}
		}
		System.out.println(max-1);
	}

	private static void bfs(List<int[]> list) {
		Deque<int[]> queue = new ArrayDeque<>();
		for(int[] i : list) {
			queue.add(new int[] {i[0],i[1]});
		}
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int x=0; x<4; x++) {
				int ni = cur[0] + di[x];
				int nj = cur[1] + dj[x];
				
				if(ni<0 || ni>N-1 || nj<0 || nj>M-1) continue;
				
				if(tomato[ni][nj]==0) {
					tomato[ni][nj] = tomato[cur[0]][cur[1]] + 1;
					queue.add(new int[] {ni,nj});
				}
			}
		}
	}
}
