import java.util.*;
import java.io.*;

public class Main {
	
	static class B {
		int idx;
		int mov;
		public B(int idx, int mov) {
			this.idx = idx;
			this.mov = mov;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<B> queue = new ArrayDeque<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			B b = new B(i,Integer.parseInt(st.nextToken()));
			queue.addLast(b);
		}
		
		StringBuilder sb = new StringBuilder();
		
		B b = queue.pollFirst();
		int next = b.mov;
		sb.append(b.idx).append(" ");
		
		while(!queue.isEmpty()) {
			if(next > 0) {
				while(--next>0) {
					queue.addLast(queue.pollFirst());
				}
			} else if(next < 0) {
				while(next++ < 0) {
					queue.addFirst(queue.pollLast());
				}
			} else {
				b = queue.pollFirst();
				next = b.mov;
				sb.append(b.idx).append(" ");
			}
		}
		
		System.out.println(sb);
	}
}