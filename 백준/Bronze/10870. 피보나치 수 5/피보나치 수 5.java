import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		if(n==0) {
			System.out.println(0);
			return;
		}
		
		if(n==1 || n==2) {
			System.out.println(1);
			return;
		}
		
		int[] fib = new int[n+1];
		
		fib[1] = 1; fib[2] = 1;
		
		for(int i=3; i<=n; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		
		System.out.println(fib[n]);
	}

}