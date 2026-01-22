import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			String f = st.nextToken();
			
			switch(f) {
				case "1" -> {
					int x = Integer.parseInt(st.nextToken());
					deque.addFirst(x);
				}
				case "2" -> {
					int x = Integer.parseInt(st.nextToken());
					deque.addLast(x);
				}
				case "3" -> {
					sb.append(deque.isEmpty()?-1:deque.pollFirst()).append("\n");
				}
				case "4" -> {
					sb.append(deque.isEmpty()?-1:deque.pollLast()).append("\n");
				}
				case "5" -> {
					sb.append(deque.size()).append("\n");
				}
				case "6" -> {
					sb.append(deque.isEmpty()?1:0).append("\n");
				}
				case "7" -> {
					sb.append(deque.isEmpty()?-1:deque.peekFirst()).append("\n");
				}
				case "8" -> {
					sb.append(deque.isEmpty()?-1:deque.peekLast()).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}
