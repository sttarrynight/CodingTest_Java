import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> nums = new ArrayList<>();
		
		while(N-->0) {
			int input = Integer.parseInt(br.readLine());
			nums.add(input);
		}
		
		nums.sort((x,y)->x-y);
		
		for(int i : nums) {
			sb.append(i).append("\n");
		}
		
		System.out.println(sb);
	}
}