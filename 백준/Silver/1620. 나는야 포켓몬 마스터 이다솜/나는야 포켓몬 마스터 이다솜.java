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
		
		Map<Integer,String> numMap = new HashMap<>();
		Map<String,Integer> nameMap = new HashMap<>();
		
		for(int i=1; i<= N; i++) {
			String poketmonName = br.readLine();
			numMap.put(i, poketmonName);
			nameMap.put(poketmonName, i);
		}
		
		List<Object> answer = new ArrayList<>();
		for(int i=0; i<M; i++) {
			String input = br.readLine();
			if(nameMap.containsKey(input)) {
				answer.add(nameMap.get(input));
			} else {
				Integer inputNum = Integer.parseInt(input);
				answer.add(numMap.get(inputNum));
			}
		}
		
		for(Object o : answer) {
			System.out.println(o.toString());
		}
	}

}