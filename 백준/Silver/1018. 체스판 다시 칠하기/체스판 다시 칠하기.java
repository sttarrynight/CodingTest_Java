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
				char compChar = board[i].charAt(j);
				for(int k=0;k<2;k++) {
					int cnt = 0;
					if(k==1) {
						compChar = compChar=='B'?'W':'B';
					}
					row = i;
					col=j;
					if(compChar=='B') {
						while(row < i+8) {
							while(col < j+8) {
								if(row%2 == i%2) {
									if(col%2 == j%2) {
										cnt += board[row].charAt(col)=='B'?0:1;
									} else {
										cnt += board[row].charAt(col)=='W'?0:1;
									}
								} else {
									if(col%2 == j%2) {
										cnt += board[row].charAt(col)=='W'?0:1;
									} else {
										cnt += board[row].charAt(col)=='B'?0:1;
									}
								}
								col++;
							}
							col = j;
							row++;
						}
					} else {
						while(row < i+8) {
							while(col < j+8) {
								if(row%2 == i%2) {
									if(col%2 == j%2) {
										cnt += board[row].charAt(col)=='W'?0:1;
									} else {
										cnt += board[row].charAt(col)=='B'?0:1;
									}
								} else {
									if(col%2 == j%2) {
										cnt += board[row].charAt(col)=='B'?0:1;
									} else {
										cnt += board[row].charAt(col)=='W'?0:1;
									}
								}
								col++;
							}
							col = j;
							row++;
						}
					}
					if(cnt<min) {
						min = cnt;
					}
				}
			}
		}
		System.out.println(min);
	}
}