import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); sc.nextLine();
		int B = sc.nextInt();
		int result = A*B;
		
		for(int i=0;i<3;i++) {
			System.out.println(A*(B%10));
			B /= 10;
		}
		System.out.println(result);
	}
}