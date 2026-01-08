import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		visited = new int[100001];
		
		if(N==K) {
			System.out.println(0);
		} else {
			System.out.println(bfs(N,K));
		}
	}

	private static int bfs(int n, int k) {
		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(n);
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			int[] move = {cur-1, cur+1, cur*2};
			
			for(int i : move) {
				if(i==k) {
					return visited[cur] + 1;
				}
				if(i<0 || i>100000) {
					continue;
				}
				if(visited[i]==0) {
					visited[i] = visited[cur] + 1;
					queue.add(i);
				}
			}
		}
		return 0;
	}
}