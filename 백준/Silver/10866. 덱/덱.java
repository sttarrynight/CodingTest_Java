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
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		StringBuilder sb = new StringBuilder();
		
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			String doit = st.nextToken();
			switch(doit) {
				case "push_front" -> {
					deque.addFirst(Integer.parseInt(st.nextToken()));
				}
				case "push_back" -> {
					deque.addLast(Integer.parseInt(st.nextToken()));
				}
				case "pop_front" -> {
					sb.append(deque.isEmpty()?-1:deque.pollFirst()).append("\n");
				}
				case "pop_back" -> {
					sb.append(deque.isEmpty()?-1:deque.pollLast()).append("\n");
				}
				case "size" -> {
					sb.append(deque.size()).append("\n");
				}
				case "empty" -> {
					sb.append(deque.isEmpty()?1:0).append("\n");
				}
				case "front" -> {
					sb.append(deque.isEmpty()?-1:deque.peekFirst()).append("\n");
				}
				case "back" -> {
					sb.append(deque.isEmpty()?-1:deque.peekLast()).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}