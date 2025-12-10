import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] str = new String[N];
		
		for(int i=0; i<N; i++) {
			str[i] = br.readLine();
		}
		
		Arrays.sort(str,(s1,s2)->{
			StringTokenizer st = new StringTokenizer(s1);
			int s1Num = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(s2);
			int s2Num = Integer.parseInt(st.nextToken());
			
			return s1Num - s2Num;
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(String s : str) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
}