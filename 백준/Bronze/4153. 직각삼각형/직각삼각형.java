import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			if(str.equals("0 0 0")) {
				break;
			}
			String[] strArr = str.split(" ");
			Arrays.sort(strArr,(x,y) -> Integer.parseInt(x) - Integer.parseInt(y));
			
			if(Math.pow(Integer.parseInt(strArr[0]), 2) + Math.pow(Integer.parseInt(strArr[1]), 2) == Math.pow(Integer.parseInt(strArr[2]), 2)) {
				sb.append("right\n");
			} else {
				sb.append("wrong\n");
			}
		}
		System.out.println(sb);
	}
}