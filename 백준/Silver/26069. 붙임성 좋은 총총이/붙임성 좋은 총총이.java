import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Set<String> dance = new HashSet<>();
		dance.add("ChongChong");
		
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			String p1 = st.nextToken();
			String p2 = st.nextToken();
			if(dance.contains(p1)) {
				dance.add(p2);
			} else if(dance.contains(p2)) {
				dance.add(p1);
			}
		}
		
		System.out.println(dance.size());
	}
}