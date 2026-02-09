import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static ArrayList<Bus>[] adj;
	static int[] distance;
	static final int INF = Integer.MAX_VALUE;
	
	public static class Bus implements Comparable<Bus>{
		int stop;
		int pay;
		
		public Bus(int stop, int pay) {
			this.stop = stop;
			this.pay = pay;
		}
		
		public int compareTo(Bus b) {
			return this.pay - b.pay;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N+1];
		distance = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			adj[s].add(new Bus(e,p));
		}
		
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start, end);
		
		System.out.println(distance[end]);
	}

	private static void dijkstra(int start, int end) {
		
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		PriorityQueue<Bus> queue = new PriorityQueue<>();
		queue.offer(new Bus(start,0));
		
		while(!queue.isEmpty()) {
			Bus current = queue.poll();
			int currentStop = current.stop;
			int currentPay = current.pay;
			
			if(distance[currentStop]<currentPay) continue;
			
			if(currentStop == end) break;
			
			for(Bus next : adj[currentStop]) {
				if(distance[currentStop] + next.pay < distance[next.stop]) {
					distance[next.stop] = distance[currentStop] + next.pay;
					queue.add(new Bus(next.stop, distance[next.stop]));
				}
			}
		}
	}
}