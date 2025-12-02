import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nums = br.readLine().split(" ");
		
		long result = 0;
		for (String s : nums) {
			result += Long.parseLong(s);
		}
		System.out.println(result);
	}
}