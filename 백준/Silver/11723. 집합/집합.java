import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		int[] arr = new int[21];
		
		StringBuilder sb = new StringBuilder();
		
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
				case "add" -> {
					arr[Integer.parseInt(st.nextToken())] = 1;
				}
				case "remove" -> {
					arr[Integer.parseInt(st.nextToken())] = 0;
				}
				case "check" -> {
					int x = Integer.parseInt(st.nextToken());
					sb.append(arr[x]==1 ? 1 : 0).append("\n");
				}
				case "toggle" -> {
					int x = Integer.parseInt(st.nextToken());
					arr[x] = arr[x]==1 ? 0: 1;
				}
				case "all" -> {
					for(int i=1;i<=20;i++) arr[i] = 1;
				}
				case "empty" -> {
					arr = new int[21];
				}
			}
		}
		System.out.println(sb);
	}
}