import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;
		int sum = 0;
		int min = 101;
		for(int i=0; i<4; i++) {
			int num = Integer.parseInt(br.readLine());
			sum += num;
			if(min>num) {
				min = num;
			}
		}
		result += sum - min;
		sum = 0;
		min = 101;
		for(int i=0; i<2; i++) {
			int num = Integer.parseInt(br.readLine());
			sum += num;
			if(min>num) {
				min = num;
			}
		}
		result += sum - min;
		System.out.println(result);
	}
	
}
