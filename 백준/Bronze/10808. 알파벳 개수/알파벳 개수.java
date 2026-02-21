import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int[] abc = new int[26];
		
		for(int i=0; i<str.length(); i++) {
			abc[str.charAt(i)-'a']++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i : abc) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb);
	}

}
