import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] seq = new int[N];
		int[] arr = new int[100001];
		
		for(int i=0; i<N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int len = 0;
		int maxLen = 0;
		
		int i = 0;
		int j = 0;
		
		while(j<N) {
			if(arr[seq[j]]==K) {
				for(int k=i; k<j; k++) {
					if(seq[k]==seq[j]) {
						i = k + 1;
						arr[seq[k]]--;
						break;
					} else {
						arr[seq[k]]--;
					}
				}
				len = j-i;
			}
			arr[seq[j]]++;
			len++;
			if(len>maxLen) {
				maxLen = len;
			}
			j++;
		}
		
		System.out.println(maxLen);
	}

}
