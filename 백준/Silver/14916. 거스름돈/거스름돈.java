import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		if(N%5==0) {
			cnt = N/5;
		} else if(N<7 && N%2==0) {
			cnt = N/2;
		} else {
			while(N>1) {
				N -= 2;
				cnt++;
				if(N%5==0) {
					cnt += N/5;
					N%=5;
				}
			}
			if(N!=0) {
				cnt = -1;
			}
		}
		
		System.out.println(cnt);
	}

}
