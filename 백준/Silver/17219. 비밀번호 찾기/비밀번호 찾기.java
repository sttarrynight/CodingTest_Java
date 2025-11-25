import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		Map<String,String> memo = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split(" ");
			memo.put(input[0], input[1]);
		}
		
		List<String> answer = new ArrayList<>();
		for(int i=0; i<M; i++) {
			answer.add(memo.get(br.readLine()));
		}
		
		answer.stream().forEach(i -> System.out.println(i));
	}

}