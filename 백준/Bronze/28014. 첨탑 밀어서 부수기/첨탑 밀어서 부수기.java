import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] tops = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			tops[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			cnt++;
			if(i>0 && tops[i-1] > tops[i]) {
				cnt--;
				continue;
			}
		}
		
		System.out.println(cnt);
	}

}
