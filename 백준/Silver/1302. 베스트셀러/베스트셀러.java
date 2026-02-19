import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<String,Integer> bookCnt = new TreeMap<>();
		
		while(N-->0) {
			String str = br.readLine();
			if(!bookCnt.containsKey(str)) {
				bookCnt.put(str,1);
			} else {
				bookCnt.computeIfPresent(str, (k,v)->v+1);
			}
		}
		
		List<Map.Entry<String,Integer>> list = new ArrayList<>(bookCnt.entrySet());
		list.sort((e1,e2)->{
			if(e1.getValue()!=e2.getValue()) return e2.getValue()-e1.getValue();
			else return e1.getKey().compareTo(e2.getKey());
		});
		
		System.out.println(list.get(0).getKey());
	}

}
