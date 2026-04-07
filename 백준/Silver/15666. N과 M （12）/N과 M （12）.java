import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M;
	static int[] arr, nums;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		nums = new int[M];
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(0,0);
		
		System.out.println(sb);
	}

	private static void dfs(int depth, int beforeD) {
		if(depth==M) {
			for(int i : nums) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		int beforeW = 0;
		for(int i=0; i<N; i++) {
			if(arr[i]==beforeW) continue;
			if(arr[i]>=beforeD) {
				beforeW = arr[i];
				nums[depth] = arr[i];
				dfs(depth+1,nums[depth]);
			}
		}
	}

}
