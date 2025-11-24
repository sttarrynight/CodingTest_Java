import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Map<Integer, Integer> mapN = new HashMap<>();
		String[] inputN = br.readLine().split(" ");
		
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(inputN[i]);

			if (!mapN.containsKey(input)) {
				mapN.put(input, 1);
			} else {
				mapN.computeIfPresent(input, (k, v) -> v + 1);
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		String[] inputM = br.readLine().split(" ");
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < m; i++) {
			int input = Integer.parseInt(inputM[i]);
			if (mapN.containsKey(input)) {
				sb.append(mapN.get(input) + " ");
			} else {
				sb.append(0 + " ");
			}
		}
		
		System.out.println(sb.toString());
	}
}