import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		char[][] friends = new char[N+1][N+1];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				friends[i][j] = str.charAt(j);
			}
		}
		
		int max = 0;
		Set<Integer> set;
		
		for(int i=0; i<N; i++) {
			set = new HashSet<>();
			for(int j=0; j<N; j++) {
				if(friends[i][j] == 'Y') {
					set.add(j);
					for(int k=0; k<N; k++) {
						if(k!=i && friends[j][k] == 'Y') {
							set.add(k);
						}
					}
				}
			}
			if(set.size() > max) max = set.size();
		}
		
		System.out.println(max);
	}
}