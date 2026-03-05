import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] adj = new ArrayList[N+1];
		boolean[] visited;
		
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
		
		Deque<int[]> queue = new ArrayDeque<>();
		int min = 100000;
		int minNum = 0;
		
		for(int i=1; i<=N; i++) {
			visited = new boolean[N+1];
			visited[i] = true;
			queue.add(new int[] {i,1});
			int cnt = 0;
			while(!queue.isEmpty()) {
				int cur[] = queue.poll();
				for(int x : adj[cur[0]]) {
					if(!visited[x]) {
						cnt += cur[1];
						visited[x] = true;
						queue.add(new int[] {x,cur[1]+1});
					}
				}
			}
			if(cnt<min) {
				min = cnt;
				minNum = i;
			}
		}
		
		System.out.println(minNum);
	}

}
