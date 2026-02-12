import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int d1 = Integer.parseInt(st.nextToken());
		int d2 = Integer.parseInt(st.nextToken());
		int d3 = Integer.parseInt(st.nextToken());
		
		if(d1==d2 && d2==d3) {
			System.out.println(d2*1000+10000);
		} else if(d1!=d2 && d2!=d3 && d3!=d1) {
			System.out.println(Math.max(Math.max(d1, d2), d3)*100);
		} else {
			int num = 0;
			if(d1==d2) num = d1;
			else if(d2==d3) num = d2;
			else num = d3;
			System.out.println(num*100+1000);
		}
	}
}