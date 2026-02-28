import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> queue = new ArrayDeque<>();
		
		for(int i=1; i<=N; i++) {
			queue.addLast(i);
		}
		
		int[] card = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		int next = N;
		
		while(!queue.isEmpty()) {
			int act = Integer.parseInt(st.nextToken());
			if(act==1) {
				card[queue.pollFirst()] = next;
			} else if(act==2) {
				int n = queue.pollFirst();
				card[queue.pollFirst()] = next;
				queue.addFirst(n);
			} else {
				card[queue.pollLast()] = next;
			}
			next--;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=N; i++) {
			sb.append(card[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}
