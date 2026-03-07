import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int[] maxInfo = new int[3]; //순서대로 값,행,열
		maxInfo[0] = -1;
		
		for(int i=1; i<=9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=9; j++) {
				int x = Integer.parseInt(st.nextToken());
				if(x>maxInfo[0]) {
					maxInfo[0] = x;
					maxInfo[1] = i;
					maxInfo[2] = j;
				}
			}
		}
		
		System.out.println(maxInfo[0]);
		System.out.println(maxInfo[1] + " " + maxInfo[2]);
	}

}
