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
		
		int large = 0;
		int small = 0;
		
		if(N > M) {
			large = N;
			small = M;
		} else {
			large = M;
			small = N;
		}
		
		int gcd = 1;
		for(int i=small; i>1; i--) {
			if(N%i==0 && M%i==0) {
				gcd = i;
				break;
			}
		}
		
		int lcm = M*N;
		int idx = 1;
		while(true) {
			int comp = gcd * idx;
			if(comp%M==0 && comp%N==0) {
				lcm = comp;
				break;
			}
			idx++;
		}
		System.out.println(gcd);
		System.out.println(lcm);
	}

}