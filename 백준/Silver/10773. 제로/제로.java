import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> stack = new ArrayDeque<>();
		
		while(N-->0) {
			int input = Integer.parseInt(br.readLine());
			if(input != 0) {
				stack.addLast(input);
			} else {
				stack.pollLast();
			}
		}
		
		int sum = 0;
		for(int i : stack) {
			sum += i;
		}
		System.out.println(sum);
	}
}