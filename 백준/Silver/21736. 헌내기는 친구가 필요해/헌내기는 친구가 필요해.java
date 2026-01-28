import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] campus = new char[N][M];
		boolean[][] visited = new boolean[N][M];
		
		Deque<int[]> queue = new ArrayDeque<>();
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				campus[i][j] = str.charAt(j);
				if(campus[i][j] == 'I') {
					queue.add(new int[] {i,j});
					visited[i][j] = true;
				}
			}
		}
		
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int x=0; x<4; x++) {
				int ni = cur[0] + di[x];
				int nj = cur[1] + dj[x];
				
				if(ni<0 || ni>N-1 || nj<0 || nj>M-1) continue;
				
				if(!visited[ni][nj] && campus[ni][nj]!='X') {
					if(campus[ni][nj]=='P') cnt++;
					visited[ni][nj] = true;
					queue.add(new int[] {ni,nj});
				}
			}
		}
		
		if(cnt>0) {
			System.out.println(cnt);
		} else {
			System.out.println("TT");
		}
	}
}