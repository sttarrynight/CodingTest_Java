import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		
		char[] arr = br.readLine().toCharArray();
		
		int r = 31;
		int M = 1234567891;
		
		long hash = 0;
		
		for(int i=0; i<L; i++) {
			int ri = (int) Math.pow(r, i);
			long ar = ((arr[i] - 96) * ri) % M;
			hash += ar;
		}
		
		System.out.println(hash);
	}

}
