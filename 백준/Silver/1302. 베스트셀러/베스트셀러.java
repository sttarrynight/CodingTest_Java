import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<String,Integer> bookCnt = new TreeMap<>();
		
		int max = 0;
		
		while(N-->0) {
			String str = br.readLine();
			if(!bookCnt.containsKey(str)) {
				bookCnt.put(str,1);
			} else {
				bookCnt.put(str,bookCnt.get(str)+1);
			}
			max = Math.max(bookCnt.get(str),max);
		}
		
		List<String> list = new ArrayList<>();
		
		for(String str : bookCnt.keySet()) {
			if(bookCnt.get(str)==max) {
				list.add(str);
			}
		}
		
		Collections.sort(list);
		System.out.println(list.get(0));
	}

}
