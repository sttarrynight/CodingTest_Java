import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		str = str.toUpperCase();
		
		Map<Character,Integer> map = new HashMap<>();
		
		for(char c : str.toCharArray()) {
			if(map.containsKey(c)) {
				map.replace(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		if(map.size()==1) {
			System.out.println(str.charAt(0));
			return;
		}
		
		List<Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
		
		Collections.sort(list, new Comparator<Entry<Character,Integer>>(){
			@Override
			public int compare(Entry<Character,Integer> e1, Entry<Character,Integer> e2) {
				return e2.getValue() - e1.getValue();
			}
		});
		
		int max1 = list.get(0).getValue();
		int max2 = list.get(1).getValue();
		if(max1 != max2) {
			System.out.println(list.get(0).getKey());
		} else {
			System.out.println("?");
		}
	}
}