import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] primeCheck = new boolean[N+1];
		
		primeCheck[1] = false;
		primeCheck[2] = true;
		
		for(int i=3; i<=N; i++) {
			boolean isPrime = true;
			for(int j=2; j<=Math.sqrt(i); j++) {
				if(i%j==0) {
					isPrime = false;
					break;
				} else {
					continue;
				}
			}
			primeCheck[i] = isPrime;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=M; i<=N; i++) {
			if(primeCheck[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}
}