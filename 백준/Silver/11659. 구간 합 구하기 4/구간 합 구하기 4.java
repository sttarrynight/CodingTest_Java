import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] strNum = br.readLine().split(" ");
		
		int[] sum = new int[N];
		
		for(int i=0; i<strNum.length; i++) {
			sum[i] = i==0 ? Integer.parseInt(strNum[i]) : sum[i-1] + Integer.parseInt(strNum[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			int answer = i == 1 ? sum[j-1] : sum[j-1] - sum[i-2];
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
