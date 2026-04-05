import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M;
	static int[] arr, nums;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		nums = new int[M];
		visited = new boolean[N];
		sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(0);
		
		System.out.println(sb);
	}

	private static void dfs(int depth) {
		if(depth==M) {
			for(int i : nums) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		int before = 0;
		for(int i=0; i<N; i++) {
			if(!visited[i]) { // 세로 방향 중복 제거
				if(before == arr[i]) continue; // 가로 방향 중복 제거(같은 depth 내에서)
				visited[i] = true;
				nums[depth] = arr[i];
				before = arr[i];
				dfs(depth+1);
				visited[i] = false;
			}
		}
	}

}
