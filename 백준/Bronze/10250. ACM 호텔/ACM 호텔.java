import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int Y = 1;
			int X = 1;
			if(N > H) {
				if(N%H == 0) {
					Y = H;
					X = N/H;
				} else {
					Y = N%H;
					X = N/H + 1;
				}
			} else {
				Y = N;
			}
			sb.append(Y);
			if(X>9) sb.append(X);
			else sb.append(0).append(X);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}