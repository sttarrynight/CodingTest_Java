import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toCharArray();
		int xIdx = -1;
		int sum = 0;
		
		for(int i=0; i<arr.length-1; i++) {
			if(Character.isDigit(arr[i])) {
				int num = arr[i] - '0';
				sum += i%2==0 ? num : 3*num;
			} else {
				xIdx = i;
			}
		}
		
		int M = arr[arr.length-1]-'0';
		int answer = -1;
		
		for(int i=0; i<10; i++) {
			int x = xIdx%2==0 ? i : 3*i;
			int totalSum = sum + x;
			if(10-(totalSum%10)==M) {
				answer = i;
				break;
			}
			if(totalSum%10==0 && M==0) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
}