import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		int full = str.length()/10;
		
		for(int i=0; i<=full; i++) {
			int idx = i*10;
			if(i==full) {
				sb.append(str.substring(idx,idx+(str.length()%10)));
			} else {
				sb.append(str.substring(idx,idx+10)).append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
