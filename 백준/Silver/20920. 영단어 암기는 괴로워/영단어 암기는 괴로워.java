import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String,Integer> map = new TreeMap<>();
		
		while(N-->0) {
			String str = br.readLine();
			
			if(str.length()<M) {
				continue;
			}
			
			if(!map.containsKey(str)) {
				map.put(str, 1);
			} else {
				map.replace(str, map.get(str) + 1);
			}
		}
		
		List<Entry<String,Integer>> list = new ArrayList<>();
		for(Entry<String,Integer> e : map.entrySet()) {
			list.add(e);
		}
		
		list.sort((e1,e2)->{
			if(e1.getValue() != e2.getValue()) {
				return e2.getValue() - e1.getValue();
			}
			return e2.getKey().length() - e1.getKey().length();
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(Entry<String,Integer> e : list) {
			sb.append(e.getKey()).append("\n");
		}
		
		System.out.println(sb);
	}
}