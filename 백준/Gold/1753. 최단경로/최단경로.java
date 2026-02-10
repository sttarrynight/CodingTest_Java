import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int V;
	static int E;
	static int K;
	static List<Node>[] adj;
	static int[] distance;
	static final int INF = Integer.MAX_VALUE;
	
	public static class Node {
		int idx;
		int weight;
		
		public Node(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[V+1];
		
		for(int i=1; i<=V; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[v].add(new Node(u,w));
		}
		
		distance = new int[V+1];
		Arrays.fill(distance, INF);
		
		PriorityQueue<Node> queue = new PriorityQueue<>((n1,n2)->{
			return n1.weight - n2.weight;
		});
		
		distance[K] = 0;
		queue.add(new Node(K,0));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int curIdx = cur.idx;
			int curWeight = cur.weight;
			
			if(curWeight > distance[curIdx]) continue;
			
			for(Node next : adj[curIdx]) {
				int nextWeight = distance[curIdx] + next.weight;
				if(nextWeight<distance[next.idx]) {
					distance[next.idx] = nextWeight;
					queue.add(new Node(next.idx,distance[next.idx]));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=V; i++) {
			if(distance[i]==INF) {
				sb.append("INF").append("\n");
			} else {
				sb.append(distance[i]).append("\n");
			}
		}
		System.out.println(sb);
	}
}