import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] day = new int[N+1];
		int[] earn = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			day[i] = Integer.parseInt(st.nextToken());
			earn[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+2];
		int max = 0;
		
		for(int i=1; i<=N; i++) {
			if(dp[i]>max) max = dp[i];
			
			int next = i + day[i];
			if(next <= N+1) {
				dp[next] = Math.max(dp[next], max + earn[i]);
			}
		}
		
		if(dp[N+1]>max) max = dp[N+1];
		System.out.println(max);
	}
}