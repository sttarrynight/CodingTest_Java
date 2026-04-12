import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String N = st.nextToken();
		int numN = Integer.parseInt(N);
		int M = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		if(N.length()*numN>M) {
			for(int i=0; i<(M/N.length())+1; i++) {
				sb.append(N);
			}
			System.out.println(sb.substring(0,M));
		}
		else {
			for(int i=0; i<numN; i++) {
				sb.append(N);
			}
			System.out.println(sb);
		}
	}
	
}
