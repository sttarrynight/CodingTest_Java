import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int gom = 0;
		
		Set<String> set = new HashSet<>();
		
		while(N-->0) {
			String str = br.readLine();
			if(str.equals("ENTER")){
				set = new HashSet<>();
			} else {
				if(set.contains(str)) continue;
				set.add(str);
				gom++;
			}
		}
		
		System.out.println(gom);
	}
}