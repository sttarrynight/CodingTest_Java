import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		//입력받은 수열
		List<Integer> inputList = new ArrayList<>();
		//중복제거용
		Set<Integer> set = new HashSet<>();
		//set 정렬해서 여기 넣음 -> 인덱스 : 크기 순서
		Integer[] arr;
		
		while(st.hasMoreTokens()) {
			int i = Integer.parseInt(st.nextToken());
			inputList.add(i);
			set.add(i);
		}
		
		arr = set.toArray(new Integer[0]);
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<inputList.size(); i++) {
			sb.append(Arrays.binarySearch(arr, inputList.get(i)));
			if(i != inputList.size()-1) {
				sb.append(" ");
			}
		}
		System.out.println(sb);
	}

}