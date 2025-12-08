import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int lengthN = 0;
		int N2 = N;
		
		while(N2>0) {
			lengthN++;
			N2 /= 10;
		}
		
		int smallest = Integer.MAX_VALUE;
		int cnt = 0;
		
		for(int i=1; i<=lengthN*9; i++) {
			int con = N-i;
			int sum = 0;
			while(con>0) {
				sum += con%10;
				con /= 10;
			}
			if(sum==i) {
				cnt++;
				if(sum < smallest) {
					smallest = N-i;
				}
			}
		}
		if(cnt>0) {
			System.out.println(smallest);
		} else {
			System.out.println(0);
		}
	}
}