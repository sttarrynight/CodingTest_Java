import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = arr[0];
		int cnt = 0;
		
		while(true) {
			if(sum==M) {
				cnt++;
				sum -= arr[start];
				start++;
			} else if(sum>M) {
				sum -= arr[start];
				start++;
			} else {
				end++;
				if(end==N) break;
				sum += arr[end];
			}
		}
		
		System.out.println(cnt);
	}

}
