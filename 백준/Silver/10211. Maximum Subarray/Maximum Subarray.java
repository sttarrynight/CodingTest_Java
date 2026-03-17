import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int N;
		int[] arr;
		int[] dp;
		int max;
		
		StringBuilder sb = new StringBuilder();
		
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			dp = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dp[0] = arr[0];
			max = dp[0];
			for(int i=1; i<N; i++) {
				dp[i] = Math.max(dp[i-1]+arr[i],arr[i]);
				max = Math.max(max,dp[i]);
			}
			sb.append(max).append("\n");
		}
		
		System.out.println(sb);
	}

}
