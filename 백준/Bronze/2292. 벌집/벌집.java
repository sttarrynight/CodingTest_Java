import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int comp = 1;
		int x = 1;
		int step = 1;
		
		
		while(N > comp) {
			
			comp += 6 * x;
			x++;
			step++;
		}
		
		System.out.println(step);
	}

}