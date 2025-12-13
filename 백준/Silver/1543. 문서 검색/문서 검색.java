import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String docs = br.readLine();
		String search = br.readLine();
		
		int cnt = 0;
		
		int idx = 0;
		
		while(idx+search.length()-1 < docs.length()) {
			String subDocs = docs.substring(idx, idx+search.length());
			if(subDocs.equals(search)) {
				idx += search.length();
				cnt ++;
			} else {
				idx++;
			}
		}
		
		System.out.println(cnt);
	}

}