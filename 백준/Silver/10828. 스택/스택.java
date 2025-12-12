import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> stack = new ArrayDeque<>();
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
				case "push" -> {
					stack.addLast(Integer.parseInt(st.nextToken()));
				}
				case "pop" -> {
					sb.append(stack.size()>0?stack.pollLast():-1).append("\n");
				}
				case "size" -> {
					sb.append(stack.size()).append("\n");
				}
				case "empty" -> {
					sb.append(stack.isEmpty()?1:0).append("\n");
				}				
				case "top" -> {
					sb.append(stack.isEmpty()?-1:stack.getLast()).append("\n");
				}
				default -> {return;}
			}
		}
		System.out.println(sb);
	}
}