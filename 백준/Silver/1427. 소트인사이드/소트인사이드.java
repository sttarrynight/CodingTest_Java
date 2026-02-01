import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		
		int[] num = new int[10];
		
		for(char c : input) {
			num[c-48]++;
		}
		
		for(int i=9; i>=0; i--) {
			printNum(i,num[i]);
		}
		
		System.out.println(sb);
	}

	private static void printNum(int i, int cnt) {
		for(int x=0; x<cnt; x++) {
			sb.append(i);
		}
	}
}