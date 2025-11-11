import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a, b;
        Scanner sc = new Scanner(System.in);
        
        a = sc.nextInt();
        b = sc.nextInt();
        
        if (a > 0 && b < 10) {
            System.out.println(a + b);
        }
    }
}