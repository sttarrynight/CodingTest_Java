import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(map.containsKey(arr[i])) {
				map.replace(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		
		double sum = 0;
		for(int i : arr) {
			sum += i;
		}
		int avg = (int) Math.round(sum/N);
		sb.append(avg).append("\n");
		
		Arrays.sort(arr);
		int mid = arr[(N-1)/2];
		sb.append(mid).append("\n");
		
		List<Entry<Integer,Integer>> list = new ArrayList<>();
		for(Entry<Integer,Integer> entry : map.entrySet()) {
			list.add(entry);
		}
		Collections.sort(list,(e1,e2)->{
			if(e1.getValue()==e2.getValue()) {
				return e1.getKey() - e2.getKey();
			} else {
				return e2.getValue() - e1.getValue();
			}
		});
		if(list.size()==1) {
			sb.append(list.get(0).getKey()).append("\n");
		}else if(list.size()>1 && !list.get(0).getValue().equals(list.get(1).getValue())) {
			sb.append(list.get(0).getKey()).append("\n");
		}else if(list.size()>1 && list.get(0).getValue().equals(list.get(1).getValue())) {
			sb.append(list.get(1).getKey()).append("\n");
		}
		
		int range = arr[N-1] - arr[0];
		sb.append(range).append("\n");
		
		System.out.println(sb);
	}
}