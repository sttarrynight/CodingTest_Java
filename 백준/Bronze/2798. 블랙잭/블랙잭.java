import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] cards = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<cards.length; i++) {
			cards[i] = Integer.parseInt(st.nextToken()); 
		}
		
		int closeSum = 0;
		int compM = M;
		int sum = 0;
		for(int i=0; i<cards.length-2; i++) {
			for(int j=i+1; j<cards.length-1; j++) {
				for(int k=j+1; k<cards.length; k++) {
					sum = cards[i] + cards[j] + cards[k];
					
					if(sum == M) {
						System.out.println(sum);
						return;
					}
					
					if(M>=sum && M-sum < compM) {
						compM = M-sum;
						closeSum = sum;
					}
				}
			}
		}
		System.out.println(closeSum);
	}

}