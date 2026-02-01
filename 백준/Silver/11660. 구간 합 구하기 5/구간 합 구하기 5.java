import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int x = Integer.parseInt(st.nextToken());
				board[i][j] = j==1 ? x : x + board[i][j-1];
			}
		}
		
		int x1, x2, y1, y2;
		
		StringBuilder sb = new StringBuilder();
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			
			for(int i=x1; i<=x2; i++) {
				sum += board[i][y2] - board[i][y1-1];
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}