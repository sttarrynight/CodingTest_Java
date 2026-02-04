import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		
		int x = 0;
		
		while(M-->0) {
			x = pq.poll();
		}
		
		System.out.println(x);
	}
}