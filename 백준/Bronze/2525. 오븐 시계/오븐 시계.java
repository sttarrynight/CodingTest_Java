import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int inputM = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		M = M+inputM;
		if(M>59) {
			H = H + M/60;
			M = M%60;
			if(H>23) {
				H %= 24;
			}
		}
		sb.append(H).append(" ").append(M);
		System.out.println(sb);
	}

}