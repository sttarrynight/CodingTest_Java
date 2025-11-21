import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] num = br.readLine().split(" ");
		
		int n = Integer.parseInt(num[0]);
		int m = Integer.parseInt(num[1]);
		
		Set<String> set = new HashSet<>();
		
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			set.add(input);
		}
		
		int cnt = 0;
		for(int i=0; i<m; i++) {
			String input = br.readLine();
			if(set.contains(input)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}