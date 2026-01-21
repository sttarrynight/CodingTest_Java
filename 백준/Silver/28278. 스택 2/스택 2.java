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
		
		Deque<Integer> stack = new ArrayDeque<>();
		
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			String f = st.nextToken();
			
			switch(f) {
				case "1" -> {
					int x = Integer.parseInt(st.nextToken());
					stack.add(x);
				}
				case "2" -> {
					sb.append(stack.isEmpty()?-1:stack.pollLast()).append("\n");
				}
				case "3" -> {
					sb.append(stack.size()).append("\n");
				}
				case "4" -> {
					sb.append(stack.isEmpty()?1:0).append("\n");
				}
				case "5" -> {
					sb.append(stack.isEmpty()?-1:stack.peekLast()).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}