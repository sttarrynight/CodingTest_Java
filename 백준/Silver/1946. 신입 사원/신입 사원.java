import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class P {
		int rate1;
		int rate2;
		public P(int rate1, int rate2) {
			this.rate1 = rate1;
			this.rate2 = rate2;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			
			PriorityQueue<P> pq = new PriorityQueue<>((p1,p2)->{
				return p1.rate1 - p2.rate1;
			});
			
			while(N-->0) {
				st = new StringTokenizer(br.readLine());
				int r1 = Integer.parseInt(st.nextToken());
				int r2 = Integer.parseInt(st.nextToken());
				P p = new P(r1, r2);
				pq.add(p);
			}
			
			int comp = pq.poll().rate2;
			int cnt = 1;
			
			while(!pq.isEmpty()) {
				int r2 = pq.poll().rate2;
				if(r2 < comp) {
					comp = r2;
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
}