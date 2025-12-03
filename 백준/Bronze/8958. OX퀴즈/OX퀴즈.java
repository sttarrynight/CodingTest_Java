import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(N-->0) {
			String[] str = br.readLine().split("");
			int total = 0;
			int score = 1;
			for(int i=0; i<str.length; i++) {
				if(str[i].equals("O")) {
					total += score;
					score++;
				} else {
					score = 1;
				}
			}
			sb.append(total).append("\n");
		}
		System.out.println(sb);
	}
}