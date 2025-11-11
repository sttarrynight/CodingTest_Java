import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt(); sc.nextLine();
		int sum = 0;
		
		String[] arr = new String[cnt];
		String s = sc.next();
		
		for(int i=0;i<cnt;i++) {
			arr[i] = s.charAt(i)+"";
		}
		
		for(String sNum : arr) {
			sum += Integer.parseInt(sNum);
		}
		
		System.out.println(sum);
	}

}