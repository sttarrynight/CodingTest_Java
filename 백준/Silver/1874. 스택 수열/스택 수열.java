import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		int num = 1;
		StringBuilder sb = new StringBuilder();
		boolean isNO = false;
		
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(!stack.isEmpty() && input < stack.lastElement()) {
				isNO = true;
			}
			
			if(stack.isEmpty() || input > stack.lastElement()) {
				while(num <= input) {
					stack.add(num++);
					sb.append("+\n");
				}
			}
			stack.pop();
			sb.append("-\n");
		}
		System.out.println(isNO ? "NO" : sb);
	}
}
