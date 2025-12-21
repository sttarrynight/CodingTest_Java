import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static LinkedList<Integer> adj[];
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		adj = new LinkedList[N+1];
		
		for(int i=0; i<=N; i++) {
			adj[i] = new LinkedList();
		}
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[v].add(w);
			adj[w].add(v);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(adj[i]);
		}
		
		sb = new StringBuilder();
		
		visited = new boolean[N+1];
		DFS(V);
		
		sb.append("\n");
		
		visited = new boolean[N+1];
		BFS(V);
		
		System.out.println(sb);
	}

	private static void BFS(int v) {
		Deque<Integer> queue = new ArrayDeque<>();
		visited[v] = true;
		queue.add(v);
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			sb.append(x).append(" ");
			for(int y : adj[x]) {
				if(!visited[y]) {
					visited[y] = true;
					queue.add(y);
				}
			}
		}
	}

	private static void DFS(int v) {
		if(visited[v]) {
			return;
		}
		
		visited[v] = true;
		sb.append(v).append(" ");
		for(int x : adj[v]) {
			if(!visited[x]) {
				DFS(x);
			}
		}
	}
}