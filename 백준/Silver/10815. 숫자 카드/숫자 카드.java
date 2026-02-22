import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Set<Integer> set = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		
		while(N-->0) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(M-->0) {
			int card = Integer.parseInt(st.nextToken());
			sb.append(set.contains(card)?1:0).append(" ");
		}
		
		System.out.println(sb);
	}

}
