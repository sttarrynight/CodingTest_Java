import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static List<Bus>[] adj;
	
	public static class Bus {
		int stop;
		int pay;
		
		public Bus(int stop, int pay) {
			this.stop = stop;
			this.pay = pay;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[v].add(new Bus(u,w));
		}
		
		int[][] distance = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		
		PriorityQueue<Bus> pq;
		
		for(int i=1; i<=N; i++) {
			distance[i][i] = 0;
			
			pq = new PriorityQueue<>((b1,b2)->{
				return b1.pay - b2.pay;
			});
			pq.add(new Bus(i,distance[i][i]));
			
			while(!pq.isEmpty()) {
				Bus current = pq.poll();
				
				if(distance[i][current.stop] < current.pay) continue;
				
				for(Bus next : adj[current.stop]) {
					if(distance[i][current.stop]+next.pay<distance[i][next.stop]) {
						distance[i][next.stop] = distance[i][current.stop]+next.pay;
						pq.add(new Bus(next.stop,distance[i][next.stop]));
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=N;i++) {
			for(int j=1; j<=N; j++) {
				if(distance[i][j]==Integer.MAX_VALUE) {
					sb.append(0).append(" ");
				} else {
					sb.append(distance[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}