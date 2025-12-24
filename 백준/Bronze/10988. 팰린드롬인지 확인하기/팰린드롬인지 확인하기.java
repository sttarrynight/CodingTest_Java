import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		List<Character> list = new ArrayList<>();
		List<Character> reverseList = new ArrayList<>();
		
		for(char c : str.toCharArray()) {
			list.add(c);
			reverseList.add(c);
		}
		
		Collections.reverse(reverseList);
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) != reverseList.get(i)){
				System.out.println(0);
				return;
			}
		}
		System.out.println(1);
	}
}