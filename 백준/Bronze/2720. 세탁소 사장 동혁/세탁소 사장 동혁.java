import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(N-->0) {
			int coin = Integer.parseInt(br.readLine());
			sb.append(coin/25).append(" ");
			coin%=25;
			sb.append(coin/10).append(" ");
			coin%=10;
			sb.append(coin/5).append(" ");
			coin%=5;
			sb.append(coin).append(" ");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
