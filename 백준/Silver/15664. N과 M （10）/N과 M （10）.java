import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M;
	static int[] arr,nums;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		nums = new int[M];
		visited = new boolean[N];
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(0,0);
		
		System.out.println(sb);
	}

	private static void dfs(int depth, int beforeDepth) {
		if(depth==M) {
			for(int i=0; i<M; i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		int beforeWidth = 0;
		for(int i=0; i<N; i++) {
			if(!visited[i] && arr[i]>=beforeDepth) {
				if(beforeWidth == arr[i]) continue;
				visited[i] = true;
				nums[depth] = arr[i];
				beforeWidth = arr[i];
				dfs(depth+1,nums[depth]);
				visited[i] = false;
			}
		}
	}

}
