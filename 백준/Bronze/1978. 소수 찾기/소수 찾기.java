import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cnt = 0;
		
		while(N-->0) {
			boolean isPrime = true;
			int input = Integer.parseInt(st.nextToken());
			
			if(input==1) {
				continue;
			}
			
			for(int i=2; i<=Math.sqrt(input); i++) {
				if(input%i==0) {
					isPrime = false;
					break;
				} else {
					continue;
				}
			}
			
			if(isPrime) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}