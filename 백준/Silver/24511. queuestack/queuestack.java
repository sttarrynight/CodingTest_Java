import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> queue = new ArrayDeque<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			if(Integer.parseInt(st.nextToken()) == 1) {
				st2.nextToken();
				continue;
			}
			queue.addFirst(Integer.parseInt(st2.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(M-->0) {
			queue.addLast(Integer.parseInt(st.nextToken()));
			sb.append(queue.pollFirst()).append(" ");
		}
		
		System.out.println(sb);
	}
}
