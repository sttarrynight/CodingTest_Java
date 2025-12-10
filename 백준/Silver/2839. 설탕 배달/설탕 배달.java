import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int x = 0; //3kg 봉지 수
		int y = 0; //5kg 봉지 수
		int sum = Integer.MAX_VALUE;
		
		for(int i=0;i<=N/3;i++) {
			x = i;
			for(int j=0;j<=N/5;j++) {
				y = j;
				int z = 3 * x + 5 * y;
				if(z==N && x+y < sum) {
					sum = x + y;
				}
			}
		}
		
		System.out.println(sum!=Integer.MAX_VALUE ? sum : -1);
	}
}