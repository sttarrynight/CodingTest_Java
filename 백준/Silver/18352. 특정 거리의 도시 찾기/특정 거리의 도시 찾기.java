import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] adj = new ArrayList[N+1];
		int[] depth = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
		}
		
		Deque<Integer> queue = new ArrayDeque<>();
		
		depth[X] = 1;
		queue.add(X);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int x : adj[cur]) {
				if(depth[x]==0) {
					depth[x] = depth[cur]+1;
					if(depth[x]-1==K) continue;
					queue.add(x);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		
		for(int i=1; i<=N; i++) {
			if(depth[i]-1==K) {
				sb.append(i).append("\n");
				cnt++;
			}
		}
		
		System.out.println(cnt==0?-1:sb);
	}

}
