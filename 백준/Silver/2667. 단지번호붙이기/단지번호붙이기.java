import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
	
	static int N;
	static int[][] home;
	static boolean[][] visited;
	
	static int[] di = {1,-1,0,0};
	static int[] dj = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		home = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String[] st = br.readLine().split("");
			for(int j=0; j<N; j++) {
				home[i][j] = Integer.parseInt(st[j]);
			}
		}
		
		List<Integer> list = new ArrayList<>();
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0;j<N; j++) {
				if(home[i][j]==1 && !visited[i][j]) {
					int cnt = bfs(i,j);
					list.add(cnt);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append("\n");
		
		list.sort((x,y)->x-y);
		
		for(int i : list) {
			sb.append(i).append("\n");
		}
		
		System.out.println(sb);
	}

	private static int bfs(int i, int j) {
		Deque<int[]> queue = new ArrayDeque<>();
		
		int cnt = 0;
		
		visited[i][j] = true;
		queue.add(new int[] {i,j});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			cnt++;
			for(int x=0; x<4; x++) {
				int ni = cur[0] + di[x];
				int nj = cur[1] + dj[x];
				
				if(ni<0 || ni>N-1 || nj<0 || nj>N-1) continue;
				
				if(home[ni][nj]==1 && !visited[ni][nj]) {
					visited[ni][nj] = true;
					queue.add(new int[] {ni,nj});
				}
			}
		}
		return cnt;
	}
}
