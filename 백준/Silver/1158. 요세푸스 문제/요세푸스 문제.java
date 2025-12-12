import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		
		List<Integer> answer = new ArrayList<>();
		int rmIdx = K-1;
		int sizeNow = list.size();
		
		for(int i=0; i<N; i++) {
			while(rmIdx >= sizeNow) {
				rmIdx -= sizeNow;
			}
			answer.add(list.remove(rmIdx));
			rmIdx--;
			rmIdx += K;
			sizeNow = list.size();
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i=0; i<answer.size(); i++) {
			sb.append(answer.get(i));
			sb.append(i!=answer.size()-1 ? ", " : ">");
		}
		System.out.println(sb);
	}
}