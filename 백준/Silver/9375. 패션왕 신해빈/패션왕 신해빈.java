import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(n-->0) {
			int num = Integer.parseInt(br.readLine());
			
			Map<String,List<String>> map = new HashMap<>();
			
			while(num-->0) {
				st = new StringTokenizer(br.readLine());
				String cloth = st.nextToken();
				String cate = st.nextToken();
				if(map.containsKey(cate)) {
					map.get(cate).add(cloth);
				} else {
					map.computeIfAbsent(cate, v -> new ArrayList<>()).add(cloth);
				}
			}
			
			int total = 1;
			
			for(String key : map.keySet()) {
				total *= map.get(key).size() + 1;
			}
			
			sb.append(total-1).append("\n");
		}
		
		System.out.println(sb);
	}
}