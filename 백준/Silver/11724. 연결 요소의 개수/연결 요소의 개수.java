import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static LinkedList<Integer> adj[];
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		adj = new LinkedList[N+1];
		
		for(int i=1; i<=N; i++) {
			adj[i] = new LinkedList();
		}
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[v].add(w);
			adj[w].add(v);
		}
		
		int count = 0;
		visited = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				count++;
				DFS(i);
			}
		}
		
		System.out.println(count);
	}

	private static void DFS(int v) {
		if(visited[v]) {
			return;
		}
		
		visited[v] = true;
		for(int x : adj[v]) {
			if(!visited[x]) {
				DFS(x);
			}
		}
	}

}