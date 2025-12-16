import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double[] score = new double[N];
		
		for(int i=0; i<score.length; i++) {
			score[i] = Double.parseDouble(st.nextToken());
		}
		
		double max = 0;
		for(double i : score) {
			if(i>max) {
				max = i;
			}
		}
		
		double sum = 0;
		for(double i: score) {
			i = i/max * 100;
			sum += i;
		}
		
		System.out.println(sum/score.length);
	}

}
