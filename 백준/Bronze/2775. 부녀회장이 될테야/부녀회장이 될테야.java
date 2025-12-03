import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(T-->0) {
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());
			int[][] apt = new int[a+1][b];
			for(int i=0;i<a+1;i++) {
				for(int j=0;j<b;j++) {
					if(i==0 | j==0) {
						apt[i][j] = j+1;
					} else {
						apt[i][j] = apt[i-1][j] + apt[i][j-1];
					}
				}
			}
			sb.append(apt[a][b-1]).append("\n");
		}
		
		System.out.println(sb);
	}
}