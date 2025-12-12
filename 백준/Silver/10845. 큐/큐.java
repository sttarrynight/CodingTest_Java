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
		
		Deque<Integer> queue = new ArrayDeque<>();
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
				case "push" -> {
					queue.addLast(Integer.parseInt(st.nextToken()));
				}
				case "pop" -> {
					sb.append(queue.size()>0?queue.pollFirst():-1).append("\n");
				}
				case "size" -> {
					sb.append(queue.size()).append("\n");
				}
				case "empty" -> {
					sb.append(queue.isEmpty()?1:0).append("\n");
				}				
				case "front" -> {
					sb.append(queue.isEmpty()?-1:queue.getFirst()).append("\n");
				}
				case "back" -> {
					sb.append(queue.isEmpty()?-1:queue.getLast()).append("\n");
				}
				default -> {return;}
			}
		}
		System.out.println(sb);
	}
}