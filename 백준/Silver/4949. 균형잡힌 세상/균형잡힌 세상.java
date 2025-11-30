import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String input = br.readLine();
			if(input.equals(".")) {
				break;
			}
			Deque<String> stack = new ArrayDeque<>();
			boolean isVPS = true;
			String[] st = input.split(""); //StringTokenizer는 빈 문자열을 토큰으로 인식하지 않음.
			int i = 0;
			while(!st[i].equals(".")) {
				if(st[i].equals("(") || st[i].equals("[")) {
					stack.push(st[i]);
					i++;
					continue;
				}
				if(st[i].equals(")")) {
					if(!stack.isEmpty() && stack.pop().equals("(")) {
						i++;
						continue;
					} else {
						isVPS = false;
						break;
					}
				}
				if(st[i].equals("]")) {
					if(!stack.isEmpty() && stack.pop().equals("[")) {
						i++;
						continue;
					} else {
						isVPS = false;
						break;
					}
				}
				i++;
			}
			if(stack.isEmpty() && isVPS) {
				sb.append("yes\n");
			} else {
				sb.append("no\n");
			}
		}
		System.out.println(sb);
	}

}