import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] sta = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			sta[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[N+1];
		
		dp[1] = sta[1];
		
		if(N>=2) {
			dp[2] = sta[1] + sta[2];
		}
		
		for(int i=3; i<=N; i++) {
			
			dp[i] = Math.max(dp[i-2], dp[i-3] + sta[i-1]) + sta[i];
		}
		
		System.out.println(dp[N]);
	}
}