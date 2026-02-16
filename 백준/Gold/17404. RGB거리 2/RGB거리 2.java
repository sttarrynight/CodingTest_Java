import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] rgb = new int[N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] cost;
		final int INF = 10000000;
		int min = INF;
		
		for(int t=0; t<3; t++) {
			cost = new int[N][3];
			
			for(int s=0; s<3; s++) {
				if(t==s) {
					cost[0][s] = rgb[0][s];
				} else {
					cost[0][s] = INF;
				}
			}
			
			for(int x=1; x<N; x++) {
				Arrays.fill(cost[x],INF);
			}
			
			for(int i=1; i<N; i++) {
				for(int j=0; j<3; j++) {
					for(int k=0; k<3; k++) {
						if(j==k) continue;
						cost[i][j] = Math.min(cost[i][j],rgb[i][j] + cost[i-1][k]);
					}
				}
			}
			
			cost[N-1][t] = INF;
			
			int rgb_min = INF;
			rgb_min = Math.min(cost[N-1][0],Math.min(cost[N-1][1],cost[N-1][2]));
			
			if(rgb_min < min) {
				min = rgb_min;
			}
		}
		
		System.out.println(min);
	}

}
