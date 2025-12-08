import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		for(int i=0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		
		while(M-->0) {
			int searchNum = Integer.parseInt(br.readLine());
			int right = arr.length - 1;
			int left = 0;
			int answer = -1;
			
			while(left <= right) {
				int mid = (right + left)/2;
				if(searchNum > arr[mid]) {
					left = mid + 1;
					
				} else if(searchNum < arr[mid]) {
					right = mid - 1;
					
				} else {
					answer = mid;
					break;
				}
			}
			
			if(answer == -1) {
				sb.append(answer).append("\n");
				continue;
			} else {
				while(answer>0 && arr[answer] == arr[answer-1]) {
					answer--;
				}
				sb.append(answer).append("\n");
			}
			
		}
		System.out.println(sb);
	}
	
}