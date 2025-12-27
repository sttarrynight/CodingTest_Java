import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Set<String> set;
		
		int cnt = N;
		
		while(N-->0) {
			String[] str = br.readLine().split("");
			set = new HashSet<>();
			set.add(str[0]);
			for(int i=1; i<str.length; i++) {
				if(str[i-1].equals(str[i])) continue;
				if(set.contains(str[i])) {
					cnt--;
					break;
				}
				if(!str[i-1].equals(str[i])) {
					set.add(str[i]);
				}
			}
		}
		System.out.println(cnt);
	}
}