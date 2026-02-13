import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] rgb = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] cost = new int[N][N];
		
		cost[0][0] = rgb[0][0];
		cost[0][1] = rgb[0][1];
		cost[0][2] = rgb[0][2];
		
		for(int i=1; i<N; i++) {
			Arrays.fill(cost[i], 1000001);
		}
		
		for(int i=1; i<=N-1; i++) {
			for(int j=0; j<3; j++) {
				for(int k=0; k<3; k++) {
					if(k==j) continue;
					cost[i][j] = Math.min(cost[i][j], rgb[i][j] + cost[i-1][k]);
				}
			}
		}
		
		System.out.println(Math.min(Math.min(cost[N-1][0], cost[N-1][1]), cost[N-1][2]));
	}
}
