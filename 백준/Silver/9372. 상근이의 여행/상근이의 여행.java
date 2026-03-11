import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int N,M;
		ArrayList<Integer>[] adj;
		boolean[] visited;
		Deque<Integer> queue = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			adj = new ArrayList[N+1];
			for(int i=1; i<=N; i++) {
				adj[i] = new ArrayList<>();
			}
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken());
				int u = Integer.parseInt(st.nextToken());
				adj[v].add(u);
				adj[u].add(v);
			}
			visited = new boolean[N+1];
			visited[1] = true;
			queue.add(1);
			int cnt = 0;
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				for(int x : adj[cur]) {
					if(!visited[x]) {
						visited[x] = true;
						queue.add(x);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}

}
