import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		int[] abc = new int[26];
		
		for(int i=0; i<abc.length; i++) {
			abc[i] = -1;
		}
		
		for(int i=0; i<word.length(); i++) {
			if(abc[word.charAt(i)-97]==-1) {
				abc[word.charAt(i)-97] = i;
			}
		}
		
		for(int i : abc) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}