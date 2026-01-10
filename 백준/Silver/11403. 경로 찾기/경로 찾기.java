import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] board; //입력 및 방문 결과
	static List<Integer>[] adj; //간선(인접) 저장
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		adj = new List[N];
		
		for(int i=0; i<N; i++) {
			adj[i] = new LinkedList<>();
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int x = Integer.parseInt(st.nextToken());
				board[i][j] = x;
				if(x==1) {
					adj[i].add(j);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			bfs(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	private static void bfs(int i) {
		Deque<Integer> queue = new ArrayDeque<>();
		for(int x : adj[i]) {
			queue.add(x);
		}
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int y : adj[cur]) {
				if(board[i][y]==0) {
					board[i][y] = 1;
					queue.add(y);
				}
			}
		}
	}
}