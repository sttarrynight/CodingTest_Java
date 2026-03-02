import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr,(a1,a2)->{
			if(a1[0]!=a2[0]) {
				return a1[0] - a2[0];
			} else {
				return a1[1] - a2[1];
			}
		});
		
		int before = arr[0][1];
		int cnt = 1;
		int max = 0;
		
		for(int i=1; i<N; i++) {
			if(arr[i][0]<before) {
				before = Math.min(arr[i][1],before);
			} else {
				cnt++;
				before = arr[i][1];
			}
			if(cnt>max) {
				max = cnt;
			}
		}
		
		System.out.println(max);
	}

}
