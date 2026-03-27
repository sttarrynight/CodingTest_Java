import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] tree = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int j=0;
			while(st.hasMoreTokens()) {
				tree[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<=i; j++) {
				if(j==0) {
					tree[i][j] += tree[i-1][j];
				} else if(j==i) {
					tree[i][j] += tree[i-1][j-1];
				} else {
					tree[i][j] += Math.max(tree[i-1][j],tree[i-1][j-1]);
				}
			}
		}
		
		int max = 0;
		for(int i : tree[n-1]) {
			max = Math.max(i,max);
		}
		
		System.out.println(max);
	}

}
