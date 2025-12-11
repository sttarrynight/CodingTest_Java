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
		
		String[] board = new String[N];
		
		for(int i=0; i<N; i++) {
			board[i] = br.readLine();
		}
		
		int min = Integer.MAX_VALUE;
		int row,col;
		
		for(int i=0; i<N-8+1; i++) {
			for(int j=0; j<M-8+1; j++) {
				int cntB = 0;
				int cntW = 0;
				row = i;
				col=j;
				while(row < i+8) {
					while(col < j+8) {
						if(row%2 == i%2) {
							if(col%2 == j%2) {
								cntB += board[row].charAt(col)=='B'?0:1;
								cntW += board[row].charAt(col)=='W'?0:1;
							} else {
								cntB += board[row].charAt(col)=='W'?0:1;
								cntW += board[row].charAt(col)=='B'?0:1;
							}
						} else {
							if(col%2 == j%2) {
								cntB += board[row].charAt(col)=='W'?0:1;
								cntW += board[row].charAt(col)=='B'?0:1;
							} else {
								cntB += board[row].charAt(col)=='B'?0:1;
								cntW += board[row].charAt(col)=='W'?0:1;
							}
						}
						col++;
					}
					col = j;
					row++;
				}
				int cnt = cntB>=cntW? cntW : cntB;
				if(cnt<min) {
					min = cnt;
				}
			}
		}
		System.out.println(min);
	}
}