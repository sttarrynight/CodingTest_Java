import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int K;
	static int[] arr;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		visited = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		cnt = 0;
		
		dfs(500,0);
		
		System.out.println(cnt);
	}

	private static void dfs(int power, int depth) {
		
		if(power<500) {
			return;
		}
		
		if(depth==N) {
			cnt++;
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(power + arr[i] - K, depth+1);
				visited[i] = false;
			}
		}
	}

}
