import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		List<String> list = new ArrayList<>();
		
		while(N-->0) {
			String str = br.readLine();
			if(!list.contains(str)) {
				list.add(str);
			}
		}
		
		list.sort((x,y)->{
            if(x.length() != y.length()) return x.length()-y.length();
            else return x.compareTo(y);
        });
		
		for(String s : list) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
}