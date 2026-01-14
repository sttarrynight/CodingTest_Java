import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int code1;
	static int code2;
	static int[] f;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		fib(n);
		f = new int[n+1];
		fibonacci(n);
		
		StringBuilder sb = new StringBuilder();
		sb.append(code1).append(" ").append(code2);
		System.out.println(sb);
	}

	private static int fibonacci(int n) {
		f[1] = 1; f[2] = 1;
		for(int i=3; i<=n; i++) {
			f[i] = f[i-1] + f[i-2];
			code2++;
		}
		return f[n];
	}

	private static int fib(int n) {
		if(n==1 || n==2) {
			code1++;
			return 1;
		}
		else return fib(n-1) + fib(n-2);
	}

}