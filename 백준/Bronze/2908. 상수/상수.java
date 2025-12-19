import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String[] N = st.nextToken().split("");
		String[] M = st.nextToken().split("");
		
		String tempN = N[0];
		String tempM = M[0];
		
		N[0] = N[2];
		M[0] = M[2];
		N[2] = tempN;
		M[2] = tempM;
		
		int intN = 0;
		int intM = 0;
		String str1 = "";
		String str2 = "";
		for(int i=0; i<3; i++) {
			str1 += N[i];
			str2 += M[i];
			if(i==2) {
				intN = Integer.parseInt(str1);
				intM = Integer.parseInt(str2);
			}
		}
		System.out.println(intN>intM ? intN : intM);
	}

}