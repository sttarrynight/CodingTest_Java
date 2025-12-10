import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static class P {
		int x;
		int y;
		public P(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<P> list = new ArrayList<>();
		P xy;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			xy = new P(x,y);
			list.add(xy);
		}
		
		list.sort((P1,P2) -> {
			if(P1.y != P2.y) {
				return P1.y - P2.y;
			} else {
				return P1.x - P2.x;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for (P p : list) {
			sb.append(p.x).append(" ").append(p.y).append("\n");
		}
		System.out.println(sb);
	}
}