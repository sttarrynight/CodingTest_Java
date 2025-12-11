import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] path = new int[N + 1];
		path[0] = Integer.MAX_VALUE;
		
		for(int i=2; i<=N; i++) {
			int shortest = 0;
			int r1 = 0;
			int r2 = 0;
			int r3 = 0;
			
			if(i%3==0) {
				r1 = i/3;
			}
			
			if(i%2==0) {
				r2 = i/2;
			}
			
			r3 = i-1;
			
			shortest = Math.min(path[r1], path[r2]);
			
			path[i] = Math.min(shortest, path[r3]) + 1;
		}
		
		System.out.println(path[N]);
	}
}