import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int S;
	static int[] arr;
	static int cnt;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		cnt = 0;
		dfs(0,0);
		
		if(S==0) cnt--;
		
		System.out.println(cnt);
	}

	private static void dfs(int idx, int sum) {
		if(idx==N) {
			if(sum==S) {
				cnt++;
			}
			return;
		}
		dfs(idx+1,sum+arr[idx]);
		dfs(idx+1,sum);
	}
}
