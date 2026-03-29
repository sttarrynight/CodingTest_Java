import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M;
	static int[] arr,nums;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		nums = new int[M];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		sb = new StringBuilder();
		
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
		for(int i=0; i<N; i++) {
			nums[depth] = arr[i];
			dfs(depth+1);
		}
	}

}
