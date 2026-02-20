import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		
		for(int i=1; i<=N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		
		visited = new boolean[N+1];
		parent = new int[N+1];
		
		Deque<Integer> queue = new ArrayDeque<>();
		visited[1] = true;
		queue.add(1);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int child : adj[cur]) {
				if(!visited[child]) {
					parent[child] = cur;
					visited[child] = true;
					queue.add(child);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=2; i<=N; i++) {
			sb.append(parent[i]).append("\n");
		}
		
		System.out.println(sb);
	}
}
