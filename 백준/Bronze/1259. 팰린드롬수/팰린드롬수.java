import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<String> numList = new ArrayList<>();
		List<String> answer = new ArrayList<>();
		
		boolean isStop = false;
		while(!isStop) {
			String input = br.readLine();
			if(input.equals("0")) {
				isStop = true;
			}else {
				numList.add(input);
			}
		}
		
		for(String s : numList) {
			boolean isPal = true;
			for(int i=0;i<s.length()/2;i++) {
				if(s.charAt(i)==s.charAt(s.length()-i-1)) {
					continue;
				} else {
					isPal = false;
					break;
				}
			}
			if(isPal) {
				answer.add("yes");
			} else {
				answer.add("no");
			}
		}
		
		for(String a : answer) {
			System.out.println(a);
		}
		br.close();
	}
}