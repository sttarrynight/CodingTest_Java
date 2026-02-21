import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			for(int space=i; space>0; space--) {
				sb.append(" ");
			}
			for(int star=N-i; star>0; star--) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
