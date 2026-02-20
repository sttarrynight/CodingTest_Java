import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][3];
		int[] dp = new int[D+1];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[i][0] = s;
			arr[i][1] = e;
			arr[i][2] = w;
		}
		
		dp[0] = 0;
		
		for(int i=1; i<=D; i++) {
			dp[i] = dp[i-1] + 1;
			for(int j=0; j<N; j++) {
				if(arr[j][1]>D || arr[j][1]!=i) continue;
				dp[i] = Math.min(dp[i],dp[arr[j][0]]+arr[j][2]);
			}
		}
		
		System.out.println(dp[D]);
	}

}
