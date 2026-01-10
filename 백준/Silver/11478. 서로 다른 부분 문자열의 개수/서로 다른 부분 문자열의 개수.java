import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		Set<String> set = new HashSet<>();
		
		int k=1;
		for(int i=str.length()-1; i>=0; i--) {
			for(int j=0; j<=i; j++) {
				set.add(str.substring(j,j+k));
			}
			k++;
		}
		
		System.out.println(set.size());
	}
}