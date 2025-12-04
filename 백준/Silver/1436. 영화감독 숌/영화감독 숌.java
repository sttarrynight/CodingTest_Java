import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int answer = 666;
		int index = 1;
		int num = 666;
		while(true) {
			if(N==index) break;
			num += 1;
			if(!Integer.toString(num).contains("666")) {
				continue;
			} else {
				index++;
				answer = num;
			}
		}
		System.out.println(answer);
	}
}