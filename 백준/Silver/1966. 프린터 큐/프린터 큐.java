import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class P {
		int idx; //초기 순서
		int pri; //중요도
		public P(int idx, int pri) {
			this.idx = idx;
			this.pri = pri;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			int j = 0;
			st = new StringTokenizer(br.readLine());
			
			Deque<P> queue = new ArrayDeque<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->y-x);
			
			while(M-->0) {
				int pri = Integer.parseInt(st.nextToken());
				P p = new P(j++,pri);
				queue.add(p);
				pq.add(pri);
			}
			
			int k = 1;
			while(!queue.isEmpty()) {
				int max = pq.peek();
				P p = queue.poll();
				if(max==p.pri) {
					if(p.idx==i) {
						sb.append(k).append("\n");
						break;
					}
					pq.poll();
					k++;
				} else {
					queue.add(p);
				}
			}
		}
		System.out.println(sb);
	}
}