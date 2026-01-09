import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] fibonacci = new int[41][2];
		fibonacci[0][0] = 1; fibonacci[0][1] = 0;
		fibonacci[1][0] = 0; fibonacci[1][1] = 1;
		
		StringBuilder sb = new StringBuilder();
		
		int cur = 2;
		
		while(N-->0) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) {
				sb.append(fibonacci[0][0]).append(" ").append(fibonacci[0][1]).append("\n");
			} else if(n==1) {
				sb.append(fibonacci[1][0]).append(" ").append(fibonacci[1][1]).append("\n");
			} else {
				if(n>=cur) {
					for(int i=cur; i<=n; i++) {
						fibonacci[i][0] = fibonacci[i-1][0] + fibonacci[i-2][0];
						fibonacci[i][1] = fibonacci[i-1][1] + fibonacci[i-2][1];
					}
					cur = n;
				}
				sb.append(fibonacci[n][0]).append(" ").append(fibonacci[n][1]).append("\n");
			}
		}
		System.out.println(sb);
	}
}