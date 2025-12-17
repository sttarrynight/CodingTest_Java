import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int factN = 1;
		int factK = 1;
		int NK = N-K;
		
		for(int i=N; i>NK; i--) {
			factN *= i;
			factK *= K--;
		}
		
		System.out.println(factN/factK);
	}
}