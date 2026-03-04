import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		ArrayList<Long> dpList = new ArrayList<>();
		dpList.add(0L);
		dpList.add(1L);
		dpList.add(2L);
		dpList.add(4L);
		StringBuilder sb = new StringBuilder();
		
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			if(n<=3 || n<=dpList.size()-1) sb.append(dpList.get(n)).append("\n");
			else {
				for(int i=dpList.size(); i<=n; i++) {
					dpList.add(((dpList.get(i-1)%1000000009) + (dpList.get(i-2)%1000000009) + (dpList.get(i-3)%1000000009))%1000000009);
				}
				sb.append(dpList.get(n)).append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
