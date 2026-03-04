import java.util.*;
import java.io.*;

// 백준 1238번 파티 풀이3 - 다익스트라 알고리즘(2번만으로)
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
		List<Node>[] adjReverse = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
			adjReverse[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[u].add(new Node(v,w));
			adjReverse[v].add(new Node(u,w));
		}
		
		int[] distance = new int[N+1];
		
		PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2)->{
			return n1.weight - n2.weight;
		});
		
		Arrays.fill(distance,100000001);
		distance[X] = 0;
		
		pq.add(new Node(X,distance[X]));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(distance[cur.idx]<cur.weight) continue;
			
			for(Node next : adj[cur.idx]) {
				int nextWeight = distance[cur.idx]+next.weight;
				if(nextWeight < distance[next.idx]) {
					distance[next.idx] = nextWeight;
					pq.add(new Node(next.idx,distance[next.idx]));
				}
			}
		}
		
		int[] distance2 = new int[N+1];
		
		pq = new PriorityQueue<>((n1,n2)->{
			return n1.weight - n2.weight;
		});
		
		Arrays.fill(distance2,100000001);
		distance2[X] = 0;
		
		pq.add(new Node(X,distance2[X]));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(distance2[cur.idx]<cur.weight) continue;
			
			for(Node next : adjReverse[cur.idx]) {
				int nextWeight = distance2[cur.idx]+next.weight;
				if(nextWeight < distance2[next.idx]) {
					distance2[next.idx] = nextWeight;
					pq.add(new Node(next.idx,distance2[next.idx]));
				}
			}
		}
		
		int max = 0;
		
		for(int i=1; i<=N; i++) {
			max = Math.max(max, distance[i] + distance2[i]);
		}
		
		System.out.println(max);
	}

}
