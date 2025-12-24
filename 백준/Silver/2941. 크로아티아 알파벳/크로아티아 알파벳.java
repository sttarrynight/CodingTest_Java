import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("");
		
		String[] arr = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		Set<String> set = new HashSet<>();
		for(int i=0; i<arr.length; i++) {
			set.add(arr[i]);
		}
		
		int idx = 0;
		int count = 0;
		
		while(idx<str.length) {
			if(idx<str.length-1) {
				String s2 = str[idx] + str[idx+1];
				if(set.contains(s2)) {
					count++;
					idx += 2;
					continue;
				}
			}
			
			if(idx<str.length-2) {
				String s3 = str[idx] + str[idx+1] + str[idx+2];
				if(set.contains(s3)) {
					count++;
					idx += 3;
					continue;
				}
			}
			idx++;
			count++;
		}
		
		System.out.println(count);
	}
}