import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			pq.add(Long.parseLong(st.nextToken())); 
		}
		
		for(int i=0; i<m; i++) {
			long a1 = pq.poll();
			long a2 = pq.poll();
			long hap = a1 + a2;
			a1 = hap;
			a2 = hap;
			pq.add(a1);
			pq.add(a2);
		}
		
		long sum = 0;
		
		for(long i : pq) {
			sum += i;
		}
		
		System.out.println(sum);
	}
	
}
