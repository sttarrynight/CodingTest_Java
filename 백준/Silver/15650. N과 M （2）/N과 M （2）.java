import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		visited = new boolean[N+1];
		
		dfs(0);
		
		System.out.println(sb);
	}

	private static void dfs(int depth) {
		if(depth==M) {
			for(int j=1; j<=M; j++) {
				sb.append(arr[j]).append(" ");
			}
			sb.append("\n");
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i] && arr[depth] < i) {
				visited[i] = true;
				arr[depth+1] = i;
				dfs(depth+1);
				visited[i] = false;
			}
		}
	}

}
