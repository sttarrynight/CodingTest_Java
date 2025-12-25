import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = new String[3];
		int digitIdx = -1;
		
		for(int i=0; i<3; i++) {
			arr[i] = br.readLine();
			if(!arr[i].equals("Fizz") && !arr[i].equals("Buzz") && !arr[i].equals("FizzBuzz")) {
				digitIdx = i;
			}
		}
		
		if(digitIdx == -1) {
			System.out.println("Fizz");
			return;
		}
		
		int next = Integer.parseInt(arr[digitIdx]) + (3-digitIdx);
		
		if(next%15==0) {
			System.out.println("FizzBuzz");
		} else if(next%3==0 && next%5!=0) {
			System.out.println("Fizz");
		} else if(next%3!=0 && next%5==0) {
			System.out.println("Buzz");
		} else {
			System.out.println(next);
		}
	}
}
