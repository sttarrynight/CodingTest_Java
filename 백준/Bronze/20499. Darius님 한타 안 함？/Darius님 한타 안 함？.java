import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] st = br.readLine().split("/");
		
		int K = Integer.parseInt(st[0]);
		int D = Integer.parseInt(st[1]);
		int A = Integer.parseInt(st[2]);
		
		if(K+A<D || D==0) {
			System.out.println("hasu");
		} else {
			System.out.println("gosu");
		}
	}

}
