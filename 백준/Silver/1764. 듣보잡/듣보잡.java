import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = 0, m = 0;
		n = sc.nextInt();
		m = sc.nextInt(); sc.nextLine();
		
		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		
		for(int i=0; i<n+m;i++) {
			if(i<n) {
				set.add(sc.nextLine());
			}
			else {
				String input = sc.nextLine();
				if(set.contains(input)) {
					list.add(input);
				}
			}
		}
		list.sort((s1,s2)->s1.compareTo(s2));
		System.out.println(list.size());
		list.stream().forEach(i->System.out.println(i));
	}

}