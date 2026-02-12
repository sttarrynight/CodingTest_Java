import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] nodes = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			Arrays.fill(nodes[i], 100000001);
			nodes[i][i] = 0;
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			nodes[v][u] = Math.min(nodes[v][u],w);
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					nodes[i][j] = Math.min(nodes[i][j], nodes[i][k] + nodes[k][j]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(nodes[i][j]!=100000001) {
					sb.append(nodes[i][j]).append(" ");
				} else {
					sb.append(0).append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
