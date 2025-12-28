import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[][] arr = new String[5][15];
		
		int max = 0;
		for(int i=0; i<5; i++) {
			String[] s = br.readLine().split("");
			for(int j=0; j<s.length; j++) {
				arr[i][j] = s[j];
			}
			for(int k=s.length; k<15; k++) {
				arr[i][k] = "-1";
			}
			
			if(arr[i].length>max) {
				max = arr[i].length;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int j=0; j<max; j++) {
			for(int i=0; i<5; i++) {
				if(!arr[i][j].equals("-1")) {
					sb.append(arr[i][j]);
				}
			}
		}
		
		System.out.println(sb);
	}
}