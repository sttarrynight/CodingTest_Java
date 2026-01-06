import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int R;
	static LinkedList<Integer>[] adj;
	static boolean[] visited;
	static int[] seq;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		adj = new LinkedList[N+1];
		
		for(int i=1; i<=N; i++) {
			adj[i] = new LinkedList();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		
		visited = new boolean[N+1];
		seq = new int[N+1];
		cnt = 1;
		
		dfs(R);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(seq[i]).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int r) {
		visited[r] = true;
		seq[r] = cnt++;
		Collections.sort(adj[r]);
		for(int i : adj[r]) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
	}
}
