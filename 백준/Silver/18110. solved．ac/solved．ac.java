import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		Deque<Integer> queue = new ArrayDeque<>();
		
		while(N-->0) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		list.sort((x,y)->x-y);
		
		int rm = (int) Math.round(list.size() * 0.15);
		
		int startIdx = rm;
		int endIdx = list.size() -1 - rm;
		
		int sum = 0;
		for(int i=startIdx; i<=endIdx; i++) {
			sum += list.get(i);
		}
		int avg = (int) Math.round((double)sum/(list.size()-rm*2));
		System.out.println(avg);
	}
}