import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			int line = N;
			for(int j=line+i; j>=1; j--) {
				int z = 2*i+1;
				if(j > z) {
					sb.append(" ");
				} else {
					sb.append("*");
				}
			}
			sb.append("\n");
		}
		
		for(int i=N-1; i>0; i--) {
			int line = N-1;
			for(int j=line+i; j>=1; j--) {
				int z = 2*i-1;
				if(j > z) {
					sb.append(" ");
				} else {
					sb.append("*");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}