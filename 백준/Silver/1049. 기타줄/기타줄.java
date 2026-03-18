import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int minPack = 1001;
		int minOne = 1001;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x<minPack) minPack = x;
			if(y<minOne) minOne = y;
		}
		
		if(minPack>=minOne*6) {
			System.out.println(minOne*N);
		} else {
			int m1 = (N/6+1)*minPack;
			int m2 = (N/6)*minPack + (N%6)*minOne;
			System.out.println(m1>m2?m2:m1);
		}
	}

}
