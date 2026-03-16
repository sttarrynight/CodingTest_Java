import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[] t = new long[n+1];
		
		t[0] = 1;
		
		for(int i=1; i<=n; i++) {
			long sum = 0;
			for(int j=0; j<i; j++) {
				sum += t[j]*t[i-(j+1)];
			}
			t[i] = sum;
		}
		
		System.out.println(t[n]);
	}

}
