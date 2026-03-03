import java.util.*;
import java.io.*;

// 백준 1238번 파티 풀이1 - 다익스트라 알고리즘
public class Main {
	
	static class Node {
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
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		List<Node>[] adj = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[u].add(new Node(v,w));
		}
		
		int[][] distance = new int[N+1][N+1];
		
		PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2)->{
			return n1.weight - n2.weight;
		});
		
		for(int i=1; i<=N; i++) {
			Arrays.fill(distance[i],100000001);
			distance[i][i] = 0;
			pq.add(new Node(i,distance[i][i]));
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				
				if(distance[i][cur.idx]<cur.weight) continue;
				
				for(Node next : adj[cur.idx]) {
					int nextWeight = distance[i][cur.idx]+next.weight;
					if(nextWeight < distance[i][next.idx]) {
						distance[i][next.idx] = nextWeight;
						pq.add(new Node(next.idx,distance[i][next.idx]));
					}
				}
			}
		}
		
		int max = 0;
		for(int i=1; i<=N; i++) {
			max = Math.max(max, distance[i][X] + distance[X][i]);
		}
		System.out.println(max);
	}

}
