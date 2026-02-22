import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double W = Double.parseDouble(st.nextToken());
		double H = Double.parseDouble(st.nextToken());
		
		System.out.printf("%.1f",W*H*0.5);
	}

}
