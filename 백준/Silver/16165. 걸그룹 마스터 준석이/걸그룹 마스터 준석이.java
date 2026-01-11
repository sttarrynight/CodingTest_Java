import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	static class Team {
		String name;
		Set<String> member;
		
		public Team(String name) {
			this.name = name;
			this.member = new TreeSet<>();
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<Team> set = new HashSet<>();
		
		while(N-->0) {
			String teamName = br.readLine();
			Team team = new Team(teamName);
			int cnt = Integer.parseInt(br.readLine());
			while(cnt-->0) {
				team.member.add(br.readLine());
			}
			set.add(team);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(M-->0) {
			String str = br.readLine();
			int quiz = Integer.parseInt(br.readLine());
			
			for(Team t : set) {
				if(quiz==1) {
					if(t.member.contains(str)) {
						sb.append(t.name).append("\n");
						break;
					}
				} else {
					if(t.name.equals(str)) {
						for(String s : t.member) {
							sb.append(s).append("\n");
						}
					}
				}
			}
		}
		
		System.out.println(sb);
	}
}