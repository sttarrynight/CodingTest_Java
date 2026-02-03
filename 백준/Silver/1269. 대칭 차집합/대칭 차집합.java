import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<Integer> A = new HashSet<>();
		Set<Integer> B = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		
		int cnt = 0;
		
		while(st.hasMoreTokens()) {
			if(A.contains(Integer.parseInt(st.nextToken()))) {
				cnt++;
			}
		}
		
		System.out.println((N+M)-2*cnt);
	}
}