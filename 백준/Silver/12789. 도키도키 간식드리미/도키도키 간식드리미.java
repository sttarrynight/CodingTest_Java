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
		
		Deque<Integer> queue = new ArrayDeque<>();
		Deque<Integer> stack = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			queue.add(Integer.parseInt(st.nextToken()));
		}
		
		int next = 1;
		
		while(next <= N) {
			if(!queue.isEmpty()) {
				int x = queue.peek();
				if(x==next) {
					queue.poll();
					next++;
					continue;
				} else {
					if(!stack.isEmpty() && stack.peekLast()==next) {
						stack.pollLast();
						next++;
						continue;
					}
				}
				if(!stack.isEmpty() && x>stack.peekLast()) {
					System.out.println("Sad");
					return;
				} else {
					queue.poll();
					stack.add(x);
				}
			} else {
				if(stack.isEmpty()) {
					break;
				}
				
				if(stack.peekLast()==next) {
					stack.pollLast();
					next++;
					continue;
				} else {
					System.out.println("Sad");
					return;
				}
			}
		}
		System.out.println("Nice");
	}
}