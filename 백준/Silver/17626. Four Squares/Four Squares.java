import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		Arrays.fill(arr,10);
		arr[0] = 0;
		arr[1] = 1;
		
		for(int i=2; i<=n; i++) {
			for(int j=(int)Math.sqrt(i); j>=1; j--) {
				arr[i] = Math.min(arr[i],arr[i-(int)Math.pow(j,2)]+1);
			}
		}
		
		System.out.println(arr[n]);
	}

}
