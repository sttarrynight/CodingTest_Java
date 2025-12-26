import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[8001];
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		double sum = 0;
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			arr[4000+x]++;
			
			if(x>max) max = x;
			if(x<min) min = x;
			
			sum += x;
		}
		sb.append((int)Math.round(sum/N)).append("\n");
		
		int mid = N/2+1;
		for(int i=0; i<arr.length; i++) {
			mid -= arr[i];
			if(mid<=0) {
				sb.append(i-4000).append("\n");
				break;
			}
		}
		
		int lot = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>lot) {
				lot = arr[i];
			}
		}
		boolean isSecond = false;
		int mode = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==lot) {
				if(isSecond) {
					mode = i-4000;
					lot = -1;
				} else {
					mode = i-4000;
					isSecond = true;
				}
			}
		}
		sb.append(mode).append("\n");
		
		sb.append(max-min).append("\n");
		
		System.out.println(sb);
	}
}