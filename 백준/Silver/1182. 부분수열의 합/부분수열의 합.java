import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int S;
	static int[] arr;
	static boolean[] visited;
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
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			dfs(i,0, -1);
		}
		
		System.out.println(cnt);
	}

	private static void dfs(int depth, int sum, int idx) {
		if(depth==N) {
			if(sum==S) {
				cnt++;
				return;
			}
		}
		for(int i=0; i<N; i++) {
			if(!visited[i] && idx<i) {
				visited[i] = true;
				dfs(depth+1,sum+arr[i],i);
				visited[i] = false;
			}
		}
	}
}
