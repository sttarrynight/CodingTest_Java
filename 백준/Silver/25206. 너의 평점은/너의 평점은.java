import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double sumGrade = 0;
		double sumScore = 0;
		
		for(int i=0; i<20; i++) {
			String[] st = br.readLine().split(" ");
			
			if(!st[2].equals("P")) {
				sumGrade += Double.parseDouble(st[1]) * score(st[2]);
				sumScore += Double.parseDouble(st[1]);
			}
		}
		
		System.out.println(sumGrade/sumScore);
	}

	private static double score(String st) {
		double result = -1;
		
		switch(st) {
			case "A+" -> { result = 4.5; }
			case "A0" -> { result = 4.0; }
			case "B+" -> { result = 3.5; }
			case "B0" -> { result = 3.0; }
			case "C+" -> { result = 2.5; }
			case "C0" -> { result = 2.0; }
			case "D+" -> { result = 1.5; }
			case "D0" -> { result = 1.0; }
			case "F" -> { result = 0; }
		}
		
		return result;
	}
}