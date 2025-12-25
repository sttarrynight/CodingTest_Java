import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		Set<Integer> set = new HashSet<>();
		
		StringBuilder sb = new StringBuilder();
		
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
				case "add" -> {
					set.add(Integer.parseInt(st.nextToken()));
				}
				case "remove" -> {
					int x = Integer.parseInt(st.nextToken());
					if(set.contains(x)) set.remove(x);
				}
				case "check" -> {
					int x = Integer.parseInt(st.nextToken());
					sb.append(set.contains(x) ? 1 : 0).append("\n");
				}
				case "toggle" -> {
					int x = Integer.parseInt(st.nextToken());
					if(set.contains(x)) {
						set.remove(x);
					} else {
						set.add(x);
					}
				}
				case "all" -> {
					for(int i=1;i<=20;i++) set.add(i);
				}
				case "empty" -> {
					set.clear();
				}
			}
		}
		System.out.println(sb);
	}
}