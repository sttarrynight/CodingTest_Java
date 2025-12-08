import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<>();
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		while(st1.hasMoreTokens()) {
			set.add(Integer.parseInt(st1.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		while(M-->0) {
			int input = Integer.parseInt(st2.nextToken());
			if(set.contains(input)) {
				sb.append("1\n");
			} else {
				sb.append("0\n");
			}
		}
		
		System.out.println(sb);
	}

}